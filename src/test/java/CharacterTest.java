import com.brian.Stat;
import com.brian.characters.Character;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CharacterTest {

    Character character;

    @Before
    void setUp(){
        // Create Stats for test player
        Map<Stat,Integer> stats = new HashMap<>();
        stats.put(Stat.HEALTH,100);
        stats.put(Stat.MANA,80);
        stats.put(Stat.ATTACK, 10);
        stats.put(Stat.DEFENCE, 25);

        // Create test character
        character = new Character("Test com.brian.characters.Character",
                "This is com.brian.characters.Character Description", stats, 100.00);
    }

    @Test
    void getName() {
        Assert.assertEquals("com.brian.characters.Character name should be Test com.brian.characters.Character","Test com.brian.characters.Character", character.getName());
    }

    @Test
    void getDescription() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void getStats() {
    }

    @Test
    void getSpecificStat() {
    }

    @Test
    void changeStat() {
    }

    @Test
    void hasStat() {
    }

    @Test
    void changeBalance() {
    }
}