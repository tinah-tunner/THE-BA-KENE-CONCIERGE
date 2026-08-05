package com.bakene.concierge.service;

import org.springframework.stereotype.Service;

@Service
public class ConciergeService {

    public String getWelcomeMenu() {
    return """
            🌿 BA KENE CONCIERGE

            Welcome to BA KENE! 👋🏽

            How can we assist you today?

            1. Distributor Onboarding
            2. Frequently Asked Questions
            3. Contact Support
            4. Book a Skin Consultation

            Reply with a number to continue.
            """;
}

    public String handleSelection(String currentStep, String selection) {

        selection = selection.trim();

        return switch (currentStep) {

            // =========================
            // MAIN MENU
            // =========================

            case "WELCOME" -> switch (selection) {

                case "1" -> """
                        DISTRIBUTOR ONBOARDING 👋🏽

                        What would you like to know?

                        1. About BA KENE
                        2. Packages & Products
                        3. Training Information
                        4. Onboarding Support

                        Reply with a number to continue.
                        """;

                case "2" -> """
                        FREQUENTLY ASKED QUESTIONS ❓

                        What would you like to know?

                        1. Products
                        2. Packages
                        3. Training
                        4. Becoming a Distributor

                        Reply with a number to continue.
                        """;

                case "3" -> """
                        BA KENE SUPPORT 🤝🏽

                        Our support team is ready to assist you.

                        Please provide your name and
                        tell us how we can help.

                        A BA KENE representative will assist you.
                        """;

                        case "4" -> """
        BOOK A SKIN CONSULTATION 🌿

        Let's get to know your skin.

        What is your skin type?

        1. Dry

        2. Oily

        3. Combination

        4. Sensitive

        5. Normal

        6. Not Sure

        0. Main Menu

        Reply with a number.
        """;

                default -> invalidOption();
            };


            // =========================
            // DISTRIBUTOR ONBOARDING
            // =========================

            case "DISTRIBUTOR_ONBOARDING" -> switch (selection) {

                case "1" -> """
                        ABOUT BA KENE 🌿

                        Welcome to BA KENE.

                        BA KENE provides skincare products and
                        opportunities for distributors to build
                        their business.

                        What would you like to explore?

                        1. Packages & Products
                        2. Training Information
                        3. Onboarding Support
                        0. Back

                        Reply with a number to continue.
                        """;

                case "2" -> """
                        BA KENE PACKAGES & PRODUCTS 📦

                        What would you like to explore?

                        1. Products
                        2. Package Options
                        0. Back

                        Reply with a number to continue.
                        """;

                case "3" -> """
                        BA KENE TRAINING 🎓

                        What would you like to learn about?

                        1. Product Training
                        2. Sales Training
                        3. Business Training
                        4. Training Support
                        0. Back

                        Reply with a number to continue.
                        """;

                case "4" -> """
                        BA KENE ONBOARDING SUPPORT 🤝🏽

                        What type of help do you need?

                        1. Onboarding Help
                        2. Product Help
                        3. General Support
                        0. Back

                        Reply with a number to continue.
                        """;

                default -> invalidOption();
            };


            // =========================
            // ABOUT BA KENE
            // =========================

            case "ABOUT_BAKENE" -> switch (selection) {

                case "1" -> """
                        BA KENE PACKAGES & PRODUCTS 📦

                        What would you like to explore?

                        1. Products
                        2. Package Options
                        0. Back

                        Reply with a number to continue.
                        """;

                case "2" -> """
                        BA KENE TRAINING 🎓

                        What would you like to learn about?

                        1. Product Training
                        2. Sales Training
                        3. Business Training
                        4. Training Support
                        0. Back

                        Reply with a number to continue.
                        """;

                case "3" -> """
                        BA KENE ONBOARDING SUPPORT 🤝🏽

                        What type of help do you need?

                        1. Onboarding Help
                        2. Product Help
                        3. General Support
                        0. Back

                        Reply with a number to continue.
                        """;

                case "0" -> """
                        DISTRIBUTOR ONBOARDING 👋🏽

                        What would you like to know?

                        1. About BA KENE
                        2. Packages & Products
                        3. Training Information
                        4. Onboarding Support

                        Reply with a number to continue.
                        """;

                default -> invalidOption();
            };


            // =========================
            // PACKAGES & PRODUCTS
            // =========================

            case "PACKAGES_PRODUCTS" -> switch (selection) {

                case "1" -> """
                        BA KENE PRODUCTS 🌿

                        1. Power Powder 150ml
                        2. Glass Moisturiser 30ml
                        3. Mineral Moisturising Sunscreen
                        0. Back

                        Reply with a number to continue.
                        """;

                case "2" -> """
                        BA KENE PACKAGE OPTIONS 📦

                        1. Glow Tier
                        2. Bloom Tier
                        3. Elite Tier
                        0. Back

                        Reply with a number to continue.
                        """;

                case "0" -> """
                        DISTRIBUTOR ONBOARDING 👋🏽

                        What would you like to know?

                        1. About BA KENE
                        2. Packages & Products
                        3. Training Information
                        4. Onboarding Support

                        Reply with a number to continue.
                        """;

                default -> invalidOption();
            };


            // =========================
            // PRODUCTS
            // =========================

            case "PRODUCTS" -> switch (selection) {

                case "1" -> """
                        POWER POWDER 150ml ✨

                        Power Powder is one of the BA KENE
                        skincare products.

                        Product information includes:

                        • Product purpose
                        • How to use the product
                        • Product benefits
                        • How to explain the product
                        • Customer questions

                        Reply 0 to go back.
                        """;

                case "2" -> """
                        GLASS MOISTURISER 30ml 💧

                        Glass Moisturiser is part of the
                        BA KENE skincare range.

                        Product information includes:

                        • Product purpose
                        • How to use the product
                        • Product benefits
                        • How to explain the product
                        • Customer questions

                        Reply 0 to go back.
                        """;

                case "3" -> """
                        MINERAL MOISTURISING SUNSCREEN ☀️

                        Mineral Moisturising Sunscreen is
                        part of the BA KENE skincare range.

                        Product information includes:

                        • Product purpose
                        • How to use the product
                        • Product benefits
                        • How to explain the product
                        • Customer questions

                        Reply 0 to go back.
                        """;

                case "0" -> """
                        BA KENE PACKAGES & PRODUCTS 📦

                        1. Products
                        2. Package Options
                        0. Back

                        Reply with a number to continue.
                        """;

                default -> invalidOption();
            };


            // =========================
            // PACKAGE OPTIONS
            // =========================

            case "PACKAGES" -> switch (selection) {

                case "1" -> """
                        GLOW TIER ✨

                        Entry-level package for distributors
                        beginning their BA KENE journey.

                        For current package contents,
                        pricing and availability, please
                        contact BA KENE support.

                        Reply 0 to go back.
                        """;

                case "2" -> """
                        BLOOM TIER 🌸

                        Mid-level package for distributors
                        looking to grow their BA KENE business.

                        For current package contents,
                        pricing and availability, please
                        contact BA KENE support.

                        Reply 0 to go back.
                        """;

                case "3" -> """
                        ELITE TIER 👑

                        High-value package for distributors
                        looking to grow their BA KENE business.

                        For current package contents,
                        pricing and availability, please
                        contact BA KENE support.

                        Reply 0 to go back.
                        """;

                case "0" -> """
                        BA KENE PACKAGES & PRODUCTS 📦

                        1. Products
                        2. Package Options
                        0. Back

                        Reply with a number to continue.
                        """;

                default -> invalidOption();
            };


            // =========================
            // TRAINING
            // =========================

            case "TRAINING" -> switch (selection) {

                case "1" -> """
                        PRODUCT TRAINING 📚

                        Learn about:

                        • Product knowledge
                        • Product usage
                        • Product benefits
                        • Product presentation
                        • Customer questions

                        Reply 0 to go back.
                        """;

                case "2" -> """
                        SALES TRAINING 💼

                        Learn about:

                        • Understanding customer needs
                        • Product presentation
                        • Communicating value
                        • Answering customer questions
                        • Customer follow-ups

                        Reply 0 to go back.
                        """;

                case "3" -> """
                        BUSINESS TRAINING 📈

                        Learn about:

                        • Distributor responsibilities
                        • Business growth
                        • Customer management
                        • Sales activities
                        • Building consistency

                        Reply 0 to go back.
                        """;

                case "4" -> """
                        TRAINING SUPPORT 🎓

                        For training schedules, materials
                        and additional training support,
                        please contact the BA KENE support team.

                        Reply 0 to go back.
                        """;

                case "0" -> """
                        DISTRIBUTOR ONBOARDING 👋🏽

                        1. About BA KENE
                        2. Packages & Products
                        3. Training Information
                        4. Onboarding Support

                        Reply with a number to continue.
                        """;

                default -> invalidOption();
            };


            // =========================
            // SUPPORT
            // =========================

            case "SUPPORT" -> switch (selection) {

                case "1" -> """
                        ONBOARDING HELP 🤝🏽

                        Please provide:

                        • Your name
                        • Your distributor details
                        • What you need help with

                        A BA KENE representative will assist you.

                        Reply 0 to return.
                        """;

                case "2" -> """
                        PRODUCT HELP 🌿

                        Please provide:

                        • Your name
                        • Product name
                        • Your question

                        A BA KENE representative will assist you.

                        Reply 0 to return.
                        """;

                case "3" -> """
                        GENERAL SUPPORT 📞

                        Please provide your name and
                        describe your question or concern.

                        A BA KENE representative will assist you.

                        Reply 0 to return.
                        """;

                case "0" -> """
                        DISTRIBUTOR ONBOARDING 👋🏽

                        1. About BA KENE
                        2. Packages & Products
                        3. Training Information
                        4. Onboarding Support

                        Reply with a number to continue.
                        """;

                default -> invalidOption();
            };


            // =========================
            // FAQ
            // =========================

            case "FAQ" -> switch (selection) {

                case "1" -> """
                        PRODUCT FAQ 🌿

                        BA KENE currently offers:

                        • Power Powder 150ml
                        • Glass Moisturiser 30ml
                        • Mineral Moisturising Sunscreen

                        Reply 0 to return to FAQs.
                        """;

                case "2" -> """
                        PACKAGE FAQ 📦

                        BA KENE currently offers:

                        • Glow Tier
                        • Bloom Tier
                        • Elite Tier

                        Reply 0 to return to FAQs.
                        """;

                case "3" -> """
                        TRAINING FAQ 🎓

                        Training forms part of the
                        distributor onboarding journey.

                        Reply 0 to return to FAQs.
                        """;

                case "4" -> """
                        BECOMING A DISTRIBUTOR 🤝🏽

                        BA KENE distributors receive
                        onboarding and training support.

                        For more information, please
                        contact BA KENE support.

                        Reply 0 to return to FAQs.
                        """;

                case "0" -> """
                        FREQUENTLY ASKED QUESTIONS ❓

                        1. Products
                        2. Packages
                        3. Training
                        4. Becoming a Distributor

                        Reply with a number to continue.
                        """;

                        case "SKIN_TYPE" -> """
        BOOK A SKIN CONSULTATION 🌿

        What is your skin type?

        1. Dry

        2. Oily

        3. Combination

        4. Sensitive

        5. Normal

        6. Not Sure

        0. Main Menu

        Reply with a number.
        """;

        case "SKIN_CONCERN" -> """
        🌿 BA KENE SKIN CONSULTATION

        Thank you.

        What is your MAIN skin concern?

        1. Acne

        2. Dark Marks

        3. Hyperpigmentation

        4. Dry Skin

        5. Uneven Skin Tone

        6. Sun Damage

        7. Fine Lines & Wrinkles

        8. Other

        0. Back

        Reply with a number.
        """;

        case "CONSULTATION_COMPLETE" -> """
        ✅ Thank you!

        Your skin consultation has been recorded successfully.

        A BA KENE consultant will review your consultation and assist you further.

        What would you like to do next?

        1. Book another Skin Consultation

        2. Contact Support

        0. Main Menu
        """;

                default -> invalidOption();
            };


            default -> invalidOption();
        };
    }

    private String invalidOption() {
        return """
                Sorry, I didn't understand that. ❌

                Please choose one of the available
                options from the menu.
                """;
    }
}