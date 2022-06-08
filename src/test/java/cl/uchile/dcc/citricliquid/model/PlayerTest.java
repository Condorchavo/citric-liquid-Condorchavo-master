package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.model.unit.BossUnit;
import cl.uchile.dcc.citricliquid.model.unit.Player;
import cl.uchile.dcc.citricliquid.model.unit.WildUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

// This class was made to test the unit classes
/**
 * Test suite for the players of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
public class PlayerTest {
  private final static String PLAYER_NAME = "Suguri";
  private Player suguri;
  private WildUnit chicken;
  private WildUnit roboBall;
  private WildUnit seagull;
  private BossUnit storeManager;
  private BossUnit shifuRobot;
  private BossUnit flyingCastle;


  @BeforeEach
  public void setUp() {
    suguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
    chicken = new WildUnit("Chicken", 3, -1, -1, 1);
    roboBall = new WildUnit("RoboBall", 3, -1, 1, -1);
    seagull = new WildUnit("Seagull", 3, 1, -1, -1);
    storeManager = new BossUnit("Store Manager", 8, 3, 2, -1);
    shifuRobot = new BossUnit("Shifu Robot", 7, 2, 3, -2);
    flyingCastle = new BossUnit("Flying Castle", 10, 2, 1, -3);
  }

  @Test
  public void constructorTest() {
    final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
    final var expectedChicken = new WildUnit("Chicken", 3, -1, -1, 1);
    final var expectedRoboBall = new WildUnit("RoboBall", 3, -1, 1, -1);
    final var expectedSeagull = new WildUnit("Seagull", 3, 1, -1, -1);
    final var expectedStoreManager = new BossUnit("Store Manager", 8, 3, 2, -1);
    final var expectedShifuRobot = new BossUnit("Shifu Robot", 7, 2, 3, -2);
    final var expectedFlyingCastle = new BossUnit("Flying Castle", 10, 2, 1, -3);
    Assertions.assertEquals(expectedSuguri, suguri);
    Assertions.assertEquals(expectedChicken, chicken);
    Assertions.assertEquals(expectedRoboBall, roboBall);
    Assertions.assertEquals(expectedSeagull, seagull);
    Assertions.assertEquals(expectedStoreManager, storeManager);
    Assertions.assertEquals(expectedShifuRobot, shifuRobot);
    Assertions.assertEquals(expectedFlyingCastle, flyingCastle);
  }

  @Test
  public void testEquals() {
    final var o = new Object();
    Assertions.assertNotEquals(suguri, o);
    Assertions.assertNotEquals(seagull, o);
    Assertions.assertNotEquals(storeManager, o);
    Assertions.assertEquals(suguri, suguri);
    Assertions.assertEquals(seagull, seagull);
    Assertions.assertEquals(storeManager, storeManager);
    final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
    final var expectedSeagull = new WildUnit("Seagull", 3, 1, -1, -1);
    final var expectedStoreManager = new BossUnit("Store Manager", 8, 3, 2, -1);
    Assertions.assertEquals(expectedSuguri, suguri);
    Assertions.assertEquals(expectedSeagull, seagull);
    Assertions.assertEquals(expectedStoreManager, storeManager);
  }

  @Test
  public void hitPointsTest() {
    Assertions.assertEquals(suguri.getMaxHp(), suguri.getCurrentHp());
    suguri.setCurrentHp(2);
    Assertions.assertEquals(2, suguri.getCurrentHp());
    suguri.setCurrentHp(-1);
    Assertions.assertEquals(0, suguri.getCurrentHp());
    suguri.setCurrentHp(5);
    Assertions.assertEquals(4, suguri.getCurrentHp());
  }

  @Test
  public void normaClearTest() {
    suguri.normaClear();
    Assertions.assertEquals(2, suguri.getNormaLevel());
  }

  @Test
  public void copyTest() {
    final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, -1, 2);
    final var actualSuguri = suguri.copy();
    // Checks that the copied player have the same parameters as the original
    Assertions.assertEquals(expectedSuguri, actualSuguri);
    // Checks that the copied player doesn't reference the same object
    Assertions.assertNotSame(expectedSuguri, actualSuguri);
  }

  @Test
  public void defeatPlayerTest() {
    var suguriCopy = suguri.copy();
    suguri.increaseStarsBy(20);
    suguriCopy.increaseStarsBy(30);
    int suguri_stars = suguri.getStars();
    int suguriCopy_stars = suguriCopy.getStars();
    suguri.winAgainstPlayer(suguriCopy);
    int exp_sug_stars = suguri_stars + suguriCopy_stars/2;
    int exp_sugCopy_stars = suguriCopy_stars/2;
    Assertions.assertEquals(exp_sug_stars, suguri.getStars());
    Assertions.assertEquals(exp_sugCopy_stars, suguriCopy.getStars());
    int expected_wins = 2;
    Assertions.assertEquals(expected_wins, suguri.getWins());
  }

  @Test
  public void winWildUnitTest() {
    suguri.increaseStarsBy(20);
    chicken.increaseStarsBy(50);
    int suguri_stars = suguri.getStars();
    int chicken_stars = chicken.getStars();
    suguri.winAgainstUnit(chicken);
    int exp_sug_stars = suguri_stars + chicken_stars;
    int exp_chicken_stars = 0;
    Assertions.assertEquals(exp_sug_stars, suguri.getStars());
    Assertions.assertEquals(exp_chicken_stars, chicken.getStars());
    int expected_wins = 1;
    Assertions.assertEquals(expected_wins, suguri.getWins());
  }

  @Test
  public void defeatWildUnitTest() {
    suguri.increaseStarsBy(20);
    chicken.increaseStarsBy(50);
    int suguri_stars = suguri.getStars();
    int chicken_stars = chicken.getStars();
    suguri.defeatedByUnit(chicken);
    int exp_sug_stars = suguri_stars/2;
    int exp_chicken_stars = chicken_stars + suguri_stars/2;
    Assertions.assertEquals(exp_sug_stars, suguri.getStars());
    Assertions.assertEquals(exp_chicken_stars, chicken.getStars());
    int expected_wins = 0;
    Assertions.assertEquals(expected_wins, suguri.getWins());
  }

  @Test
  public void winBossUnitTest() {
    suguri.increaseStarsBy(20);
    flyingCastle.increaseStarsBy(46);
    int suguri_stars = suguri.getStars();
    int flyingCastle_stars = flyingCastle.getStars();
    suguri.winAgainstUnit(flyingCastle);
    int exp_sug_stars = suguri_stars + flyingCastle_stars;
    int exp_flyingCastle_stars = 0;
    Assertions.assertEquals(exp_sug_stars, suguri.getStars());
    Assertions.assertEquals(exp_flyingCastle_stars, flyingCastle.getStars());
    int expected_wins = 3;
    Assertions.assertEquals(expected_wins, suguri.getWins());
  }

  @Test
  public void defeatBossUnitTest() {
    suguri.increaseStarsBy(10);
    flyingCastle.increaseStarsBy(30);
    int suguri_stars = suguri.getStars();
    int flyingCastle_stars = flyingCastle.getStars();
    suguri.defeatedByUnit(flyingCastle);
    int exp_sug_stars = suguri_stars/2;
    int exp_flyingCastle_stars = flyingCastle_stars + suguri_stars/2;
    Assertions.assertEquals(exp_sug_stars, suguri.getStars());
    Assertions.assertEquals(exp_flyingCastle_stars, flyingCastle.getStars());
    int expected_wins = 0;
    Assertions.assertEquals(expected_wins, suguri.getWins());
  }

  // region : consistency tests
  @RepeatedTest(100)
  public void hitPointsConsistencyTest() {
    final long testSeed = new Random().nextLong();
    // We're gonna try and set random hit points in [-maxHP * 2, maxHP * 2]
    final int testHP = new Random(testSeed).nextInt(4 * suguri.getMaxHp() + 1)
                       - 2 * suguri.getMaxHp();
    suguri.setCurrentHp(testHP);
    Assertions.assertTrue(0 <= suguri.getCurrentHp()
                          && suguri.getCurrentHp() <= suguri.getMaxHp(),
                          suguri.getCurrentHp() + "is not a valid HP value"
                          + System.lineSeparator() + "Test failed with random seed: "
                          + testSeed);
  }

  @RepeatedTest(100)
  public void normaClearConsistencyTest() {
    final long testSeed = new Random().nextLong();
    // We're gonna test for 0 to 5 norma clears
    final int iterations = Math.abs(new Random(testSeed).nextInt(6));
    final int expectedNorma = suguri.getNormaLevel() + iterations;
    for (int it = 0; it < iterations; it++) {
      suguri.normaClear();
    }
    Assertions.assertEquals(expectedNorma, suguri.getNormaLevel(),
                            "Test failed with random seed: " + testSeed);
  }

  @RepeatedTest(100)
  public void rollConsistencyTest() {
    final long testSeed = new Random().nextLong();
    suguri.setSeed(testSeed);
    final int roll = suguri.roll();
    Assertions.assertTrue(roll >= 1 && roll <= 6,
                          roll + "is not in [1, 6]" + System.lineSeparator()
                          + "Test failed with random seed: " + testSeed);
  }

  @RepeatedTest(100)
  public void unitBattleTest() {
    final long testSeed = new Random().nextLong();
    suguri.setSeed(testSeed);
    int init_attack = suguri.getAtk();
    int attack = suguri.unitBattle(storeManager);
    Assertions.assertTrue(attack >= init_attack + 1 && attack <= init_attack + 6,
        attack + "is not in [atk + 1, atk + 6]" + System.lineSeparator()
            + "Test failed with random seed: " + testSeed);
  }

  @RepeatedTest(100)
  public void playerBattleTest() {
    final long testSeed = new Random().nextLong();
    suguri.setSeed(testSeed);
    var suguriCopy = suguri.copy();
    int init_attack = suguri.getAtk();
    int attack = suguri.playerBattle(suguriCopy);
    Assertions.assertTrue(attack >= init_attack + 1 && attack <= init_attack + 6,
        attack + "is not in [atk + 1, atk + 6]" + System.lineSeparator()
            + "Test failed with random seed: " + testSeed);
  }
  // endregion
}
