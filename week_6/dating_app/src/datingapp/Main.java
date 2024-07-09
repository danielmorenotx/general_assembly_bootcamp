package datingapp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;


public class Main {


    public static void main(String[] args) {

        // Get the list of profiles from ProfileManager
        List<Profile> profiles = ProfileManager.getProfiles();

        // Question 1
        List<Profile> over25AndHikingProfiles = Utils.over25AndHiking(profiles);
        System.out.println("Profiles over 25 and like hiking: " + over25AndHikingProfiles);

        // Question 2
        List<Profile> youngAndLikesMoviesProfiles = Utils.youngAndLikesMovies(profiles);
        System.out.println("Profiles between 18 and 35 who like movies: " + youngAndLikesMoviesProfiles);

        // Question 3
        List<Profile> cookingOrPhotographyProfiles = Utils.cookingOrPhotography(profiles);
        System.out.println("Profiles with hobby cooking or photography: " + cookingOrPhotographyProfiles);

        // Question 4
        List<Profile> noHobbiesProfiles = Utils.noHobbies(profiles);
        System.out.println("Profiles with no empty or null hobbies: " + noHobbiesProfiles);

        // Question 5
        List<Integer> allAges = Utils.allAges(profiles);
        System.out.println("Ages of all profiles: " + allAges);

        // Question 6
        List<String> namesCapitalized = Utils.namesCapitalized(profiles);
        System.out.println("Names with the first letter capitalized: " + namesCapitalized);

        // Question 7
        boolean under18 = Utils.under18(profiles);
        System.out.println("Are there profiles under 18? " + under18);

        // Question 8
        long countLikesMusic = Utils.likeMusic(profiles);
        System.out.println("Number of profiles liking music: " + countLikesMusic);

        // Question 9
        boolean over18 = Utils.over18(profiles);
        System.out.println("Are all profiles over 18? " + over18);

        // Question 10
        List<Profile> advancedProfiles = Utils.advancedMethod(profiles);
        System.out.println("Fully completed profiles listing hobby related to arts or music: " + advancedProfiles);

    }


}
