import java.util.*;

public class Person {
    private final LinkedHashMap<String, Integer> allergiesItems;

    public Person() {
        this.allergiesItems = new LinkedHashMap() {
            {
                put("cats", 128);
                put("pollen", 64);
                put("chocolate", 32);
                put("tomatoes", 16);
                put("strawberries", 8);
                put("shellfish", 4);
                put("peanuts", 2);
                put("eggs", 1);
            }
        };
    }

    public int scoreByAllergies(String... allergies) {
        int score = 0;

        for (String allergie : allergies) {
            if (this.allergiesItems.containsKey(allergie))
                score += this.allergiesItems.get(allergie);
        }

        return score;
    }

    public String[] allergiesByScore(int score) {
        List<String> allergies = new ArrayList();

        calculateAllergies(allergies, score);

        orderAlphabetically(allergies);

        return allergies.toArray(new String[]{});
    }

    private void calculateAllergies(List<String> allergies, int score) {
        if (score < 1)
            return;

        for (Map.Entry<String, Integer> allergie : this.allergiesItems.entrySet()) {

            if (allergie.getValue() <= score) {
                score -= allergie.getValue();

                allergies.add(allergie.getKey());

                break;
            }
        }

        this.calculateAllergies(allergies, score);
    }

    private void orderAlphabetically(List<String> allergies) {
        Collections.sort(allergies);
    }
}
