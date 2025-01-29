package io.github.mayumisiano.quarkussocial.domain.enums;

public enum Tag {
    AI("Artificial Intelligence"),
    ML("Machine Learning"),
    DATA_SCIENCE("Data Science"),
    WEB_DEVELOPMENT("Web Development"),
    MOBILE_DEVELOPMENT("Mobile Development"),
    CLOUD_COMPUTING("Cloud Computing"),
    CYBER_SECURITY("Cyber Security"),
    IoT("Internet of Things"),
    BLOCKCHAIN("Blockchain"),
    DEVOPS("DevOps"),
    SOFTWARE_ENGINEERING("Software Engineering"),
    GAME_DEVELOPMENT("Game Development"),
    UI_UX("User Interface & User Experience"),
    OPEN_SOURCE("Open Source"),
    VIRTUAL_REALITY("Virtual Reality"),
    AUGMENTED_REALITY("Augmented Reality"),
    ROBOTICS("Robotics"),
    ENTERPRISE_TECH("Enterprise Technology"),
    STARTUPS("Startups"),
    TECH_TREND("Tech Trends"),
    GADGETS("Gadgets"),
    PROGRAMMING_LANGUAGES("Programming Languages");

    private final String description;

    Tag(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
