package com.bakene.concierge.controller;

import com.bakene.concierge.config.MetaConfig;
import com.bakene.concierge.service.ConversationService;
import com.bakene.concierge.service.WhatsAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
@CrossOrigin(origins = "*")
public class WebhookController {

    private final ConversationService conversationService;
    private final WhatsAppService whatsAppService;
    private final MetaConfig metaConfig;

    public WebhookController(
            ConversationService conversationService,
            WhatsAppService whatsAppService,
            MetaConfig metaConfig) {

        this.conversationService = conversationService;
        this.whatsAppService = whatsAppService;
        this.metaConfig = metaConfig;
    }

    @GetMapping
    public ResponseEntity<String> verifyWebhook(

            @RequestParam("hub.mode") String mode,

            @RequestParam("hub.verify_token") String verifyToken,

            @RequestParam("hub.challenge") String challenge) {

        if ("subscribe".equals(mode)
                && metaConfig.getVerifyToken().equals(verifyToken)) {

            return ResponseEntity.ok(challenge);
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("Verification failed");
    }

    @PostMapping
    public ResponseEntity<String> receiveMessage(
            @RequestBody Map<String, Object> payload) {

        try {

            List<Map<String, Object>> entries =
                    (List<Map<String, Object>>) payload.get("entry");

            for (Map<String, Object> entry : entries) {

                List<Map<String, Object>> changes =
                        (List<Map<String, Object>>) entry.get("changes");

                for (Map<String, Object> change : changes) {

                    Map<String, Object> value =
                            (Map<String, Object>) change.get("value");

                    if (!value.containsKey("messages"))
                        continue;

                    List<Map<String, Object>> messages =
                            (List<Map<String, Object>>) value.get("messages");

                    for (Map<String, Object> message : messages) {

                        String from =
                                (String) message.get("from");

                        Map<String, Object> text =
                                (Map<String, Object>) message.get("text");

                        if (text == null)
                            continue;

                        String body =
                                (String) text.get("body");

                        String reply =
                                conversationService.processMessage(from, body);

                        whatsAppService.sendMessage(from, reply);
                    }
                }
            }

            return ResponseEntity.ok("EVENT_RECEIVED");

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.ok("EVENT_RECEIVED");
        }
    }
}