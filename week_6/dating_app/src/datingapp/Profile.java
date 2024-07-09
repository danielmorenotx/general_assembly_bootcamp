package datingapp;

public class Profile {
    // initializing attributes of Profile
    String profileName;
    String profileDescription;
    String hobby;
    int age;
    String likes;
    Boolean superUser;



    // constructor to initialize all attributes
    public Profile(String profileName, String profileDescription, String hobby, int age, String likes, Boolean superUser) {
        this.profileName = profileName;
        this.profileDescription = profileDescription;
        this.hobby = hobby;
        this.age = age;
        this.likes = likes;
        this.superUser = superUser;
    }

    public Profile(String profileName, String profileDescription, String hobby, int age, String likes) {
        this.profileName = profileName;
        this.profileDescription = profileDescription;
        this.hobby = hobby;
        this.age = age;
        this.likes = likes;
    }

    // getters and setters for all attributes

    // ======= PROFILE NAME =======
    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    // ======= PROFILE DESCRIPTION =======
    public String getProfileDescription() {
        return profileDescription;
    }


    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    // ======= HOBBY =======
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    // ======= AGE =======
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ======= LIKES =======
    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    // ======= SUPER USER =======
    public Boolean getSuperUser() {
        return superUser;
    }

    public void setSuperUser(Boolean superUser) {
        this.superUser = superUser;
    }

    // Override toString() method to provide custom string representation
    @Override
    public String toString() {
        return "Profile{" +
                "profileName='" + profileName + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                ", hobby='" + hobby + '\'' +
                ", age=" + age +
                ", likes='" + likes + '\'' +
                ", superUser=" + superUser +
                '}';
    }
}
