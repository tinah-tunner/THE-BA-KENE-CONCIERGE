package com.bakene.concierge.service;

import com.bakene.concierge.entity.Conversation;
import com.bakene.concierge.entity.Message;
import com.bakene.concierge.repository.ConversationRepository;
import com.bakene.concierge.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;
    private final ConciergeService conciergeService;

    public ConversationService(
            ConversationRepository conversationRepository,
            MessageRepository messageRepository,
            ConciergeService conciergeService) {

        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
        this.conciergeService = conciergeService;
    }

    public Conversation createConversation(String whatsappNumber, String userType) {

        Conversation conversation = new Conversation();

        conversation.setWhatsappNumber(whatsappNumber);
        conversation.setUserType(userType);
        conversation.setCurrentStep("WELCOME");
        conversation.setStatus("ACTIVE");

        return conversationRepository.save(conversation);
    }

    public Optional<Conversation> getConversation(String whatsappNumber) {
        return conversationRepository.findByWhatsappNumber(whatsappNumber);
    }

    public Conversation saveConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    public String processMessage(String whatsappNumber, String message) {

        Conversation conversation = conversationRepository
                .findByWhatsappNumber(whatsappNumber)
                .orElseGet(() -> createConversation(whatsappNumber, "DISTRIBUTOR"));

        String cleanMessage = message.trim().toLowerCase();

        String currentStep = conversation.getCurrentStep();
        String nextStep = currentStep;

        /*
         * Greetings always restart the conversation
         */

        if (cleanMessage.equals("hi")
                || cleanMessage.equals("hello")
                || cleanMessage.equals("hey")
                || cleanMessage.equals("start")
                || cleanMessage.equals("menu")) {

            nextStep = "WELCOME";
        }

        else {

            switch (currentStep) {

                case "WELCOME":

                    if (cleanMessage.equals("1")) {
                        nextStep = "DISTRIBUTOR_ONBOARDING";
                    }

                    else if (cleanMessage.equals("2")) {
                        nextStep = "FAQ";
                    }

                    else if (cleanMessage.equals("3")) {
                        nextStep = "SUPPORT";
                    }

                    else if (cleanMessage.equals("4")) {
                        nextStep = "SKIN_TYPE";
                    }

                    break;

                                    case "DISTRIBUTOR_ONBOARDING":

                    if (cleanMessage.equals("1")) {
                        nextStep = "ABOUT_BAKENE";
                    }

                    else if (cleanMessage.equals("2")) {
                        nextStep = "PACKAGES_PRODUCTS";
                    }

                    else if (cleanMessage.equals("3")) {
                        nextStep = "TRAINING";
                    }

                    else if (cleanMessage.equals("4")) {
                        nextStep = "SUPPORT";
                    }

                    else if (cleanMessage.equals("0")) {
                        nextStep = "WELCOME";
                    }

                    break;

                case "ABOUT_BAKENE":

                    if (cleanMessage.equals("1")) {
                        nextStep = "PACKAGES_PRODUCTS";
                    }

                    else if (cleanMessage.equals("2")) {
                        nextStep = "TRAINING";
                    }

                    else if (cleanMessage.equals("3")) {
                        nextStep = "SUPPORT";
                    }

                    else if (cleanMessage.equals("0")) {
                        nextStep = "DISTRIBUTOR_ONBOARDING";
                    }

                    break;

                case "PACKAGES_PRODUCTS":

                    if (cleanMessage.equals("1")) {
                        nextStep = "PRODUCTS";
                    }

                    else if (cleanMessage.equals("2")) {
                        nextStep = "PACKAGES";
                    }

                    else if (cleanMessage.equals("0")) {
                        nextStep = "DISTRIBUTOR_ONBOARDING";
                    }

                    break;

                case "PRODUCTS":

                    if (cleanMessage.equals("0")) {
                        nextStep = "PACKAGES_PRODUCTS";
                    }

                    break;

                case "PACKAGES":

                    if (cleanMessage.equals("0")) {
                        nextStep = "PACKAGES_PRODUCTS";
                    }

                    break;

                case "TRAINING":

                    if (cleanMessage.equals("0")) {
                        nextStep = "DISTRIBUTOR_ONBOARDING";
                    }

                    break;

                case "SUPPORT":

                    if (cleanMessage.equals("0")) {
                        nextStep = "WELCOME";
                    }

                    break;

                case "FAQ":

                    if (cleanMessage.equals("0")) {
                        nextStep = "WELCOME";
                    }

                    break;

                case "SKIN_TYPE":

                    if (cleanMessage.equals("1")) {
                        conversation.setSkinType("Dry");
                        nextStep = "SKIN_CONCERN";
                    }

                    else if (cleanMessage.equals("2")) {
                        conversation.setSkinType("Oily");
                        nextStep = "SKIN_CONCERN";
                    }

                    else if (cleanMessage.equals("3")) {
                        conversation.setSkinType("Combination");
                        nextStep = "SKIN_CONCERN";
                    }

                    else if (cleanMessage.equals("4")) {
                        conversation.setSkinType("Sensitive");
                        nextStep = "SKIN_CONCERN";
                    }

                    else if (cleanMessage.equals("5")) {
                        conversation.setSkinType("Normal");
                        nextStep = "SKIN_CONCERN";
                    }

                    else if (cleanMessage.equals("6")) {
                        conversation.setSkinType("Not Sure");
                        nextStep = "SKIN_CONCERN";
                    }

                    else if (cleanMessage.equals("0")) {
                        nextStep = "WELCOME";
                    }

                    break;

                case "SKIN_CONCERN":

                    if (cleanMessage.equals("1")) {
                        conversation.setSkinConcern("Acne");
                        nextStep = "CONSULTATION_COMPLETE";
                    }

                    else if (cleanMessage.equals("2")) {
                        conversation.setSkinConcern("Dark Marks");
                        nextStep = "CONSULTATION_COMPLETE";
                    }

                    else if (cleanMessage.equals("3")) {
                        conversation.setSkinConcern("Hyperpigmentation");
                        nextStep = "CONSULTATION_COMPLETE";
                    }

                    else if (cleanMessage.equals("4")) {
                        conversation.setSkinConcern("Dry Skin");
                        nextStep = "CONSULTATION_COMPLETE";
                    }

                    else if (cleanMessage.equals("5")) {
                        conversation.setSkinConcern("Uneven Skin Tone");
                        nextStep = "CONSULTATION_COMPLETE";
                    }

                    else if (cleanMessage.equals("6")) {
                        conversation.setSkinConcern("Sun Damage");
                        nextStep = "CONSULTATION_COMPLETE";
                    }

                    else if (cleanMessage.equals("7")) {
                        conversation.setSkinConcern("Fine Lines");
                        nextStep = "CONSULTATION_COMPLETE";
                    }

                    else if (cleanMessage.equals("8")) {
                        conversation.setSkinConcern("Other");
                        nextStep = "CONSULTATION_COMPLETE";
                    }

                    else if (cleanMessage.equals("0")) {
                        nextStep = "SKIN_TYPE";
                    }

                    break;

                case "CONSULTATION_COMPLETE":

                    if (cleanMessage.equals("1")) {
                        nextStep = "SKIN_TYPE";
                    }

                    else if (cleanMessage.equals("2")) {
                        nextStep = "SUPPORT";
                    }

                    else if (cleanMessage.equals("0")) {
                        nextStep = "WELCOME";
                    }

                    break;
            }
        }
                conversation.setCurrentStep(nextStep);
        conversationRepository.save(conversation);

        // Save customer's incoming message
        Message userMessage = new Message();
        userMessage.setConversation(conversation);
        userMessage.setSender(whatsappNumber);
        userMessage.setDirection("INCOMING");
        userMessage.setMessage(message);

        messageRepository.save(userMessage);

        // Generate bot reply
        String botReply;

        if ("WELCOME".equals(nextStep)
                && (cleanMessage.equals("hi")
                || cleanMessage.equals("hello")
                || cleanMessage.equals("hey")
                || cleanMessage.equals("start")
                || cleanMessage.equals("menu"))) {

            botReply = conciergeService.getWelcomeMenu();

        } else {

            botReply = conciergeService.handleSelection(nextStep, cleanMessage);
        }

        // Save bot reply
        Message botMessage = new Message();
        botMessage.setConversation(conversation);
        botMessage.setSender("BA KENE");
        botMessage.setDirection("OUTGOING");
        botMessage.setMessage(botReply);

        messageRepository.save(botMessage);

        return botReply;
    }
}