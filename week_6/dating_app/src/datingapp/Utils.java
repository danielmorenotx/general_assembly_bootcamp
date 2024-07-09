package datingapp;

import java.util.List;
import java.util.Objects;

public class Utils {

    // Question 1. Use the filter method to find all profiles where the age is greater than 25 and the hobby is "hiking".

    public static List<Profile> over25AndHiking(List<Profile> profiles) {
        return profiles.stream()
                .filter(profile -> profile.age > 25 && profile.hobby.contains("hiking"))
                .toList();
    }


    // Question 2. Find all profiles where the user is between 18 and 35 years old, and likes contain "movies".
    public static List<Profile> youngAndLikesMovies(List<Profile> profiles) {
        return profiles.stream()
                .filter(profile -> profile.age > 18 && profile.age < 35 && profile.likes.contains("movies"))
                .toList();
    }

    // Question 3. Filter profiles to find users whose hobby is either "cooking" or "photography".
    public static List<Profile> cookingOrPhotography(List<Profile> profiles) {
        return profiles.stream()
                .filter(profile -> profile.hobby.contains("cooking") || profile.hobby.equalsIgnoreCase("photography"))
                .toList();
    }

    // Question 4. It's important for our dating app to encourage complete profiles for better matchmaking.
    // Use the filter method to exclude (remove) profiles where the hobby field is either empty or null.
    public static List<Profile> noHobbies(List<Profile> profiles) {
        return profiles.stream()
                .filter(profile -> profile.hobby != null || profile.hobby != "")
                .toList();
    }

    // Question 5. Generate a list of integers representing the ages of all profiles.
    public static List<Integer> allAges(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAge)
                .toList();
    }

    // Question 6. Generate a list of all names with the first letter capitalized.
    public static List<String> namesCapitalized(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> {
                    String name = profile.profileName;
                    return Character.toUpperCase(name.charAt(0)) + name.substring(1);
                })
                .toList();
    }

    // Question 7. Verify if there are any profiles in the list where the user is under 18 years old.
    // This check is crucial for ensuring that all users meet the age requirement of the dating app.
    // Use anyMatch() to determine if any such profiles exist.
    public static Boolean under18(List<Profile> profiles) {
        return profiles.stream()
                .anyMatch(profile -> profile.getAge() < 18);
    }

    // Question 8. Count how many profiles mention "music" in their likes.
    // This operation is useful for understanding the popularity of interests within the app,
    // which can inform event planning or feature development.
    // Use the count() method after filtering profiles to only include those that have "music" in their likes.
    public static long likeMusic(List<Profile> profiles) {
        return profiles.stream()
                .filter(profile -> profile.getHobby().contains("music"))
                .count();
    }

    // Question 9. Ensure all users are of legal age to use the app by checking that every profile represents a user who is at least 18 years old.
    // This is crucial for compliance and safety reasons.
    // Use allMatch() to verify that all profiles meet this age requirement.
    public static Boolean over18(List<Profile> profiles) {
        return profiles.stream()
                .allMatch(profile -> profile.getAge() >= 18);
    }

    // Question 10. Using chained methods, Filter profiles to include only those that are fully completed.
    // A profile is considered fully completed if none of its attributes (profileDescription, hobby, likes) are empty or null.
    // Then transform the profile to have a super user attribute of true.
    // Then Count how many of these fully completed profiles list a hobby that is related to "arts" or "music".
    public static List<Profile> advancedMethod(List<Profile> profiles) {
        return profiles.stream()
                .filter(profile ->
                        !profile.getProfileDescription().isEmpty() &&
                        !profile.getHobby().isEmpty() &&
                        !profile.getLikes().isEmpty())
                .map(profile -> {
                    profile.setSuperUser(true);
                    return profile;})
                .filter(profile ->
                        profile.getHobby().contains("arts") ||
                        profile.getHobby().contains("music"))
                .toList();
    }


}
