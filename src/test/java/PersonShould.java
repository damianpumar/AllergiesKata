import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonShould {
    private Person person;

    @Before
    public void setup() {
        person = new Person();
    }

    @Test
    public void score_2_When_Person_Is_Allergic_To_Peanuts() {
        assertThat(person.scoreByAllergies("peanuts")).isEqualTo(2);
    }

    @Test
    public void score_1_When_Person_Is_Allergic_To_Eggs() {
        assertThat(person.scoreByAllergies("eggs")).isEqualTo(1);
    }

    @Test
    public void score_3_When_Person_Is_Allergic_To_Eggs_And_Peanuts() {
        assertThat(person.scoreByAllergies("eggs", "peanuts")).isEqualTo(3);
    }

    @Test
    public void score_0_When_Person_Do_Not_Have_Allergies() {
        assertThat(person.scoreByAllergies()).isEqualTo(0);
    }

    @Test
    public void score_0_When_Person_Is_Allergic_To_Apples() {
        assertThat(person.scoreByAllergies("apples")).isEqualTo(0);
    }

    @Test
    public void return_cats_When_Person_Has_Score_128() {
        assertThat(person.allergiesByScore(128)).isEqualTo(new String[]{"cats"});
    }

    @Test
    public void return_All_Allergies_Alphabetically_When_Person_Has_Score_255() {
        assertThat(person.allergiesByScore(255)).isEqualTo(
                new String[]{"cats", "chocolate", "eggs", "peanuts", "pollen", "shellfish", "strawberries", "tomatoes"}
        );
    }
}
