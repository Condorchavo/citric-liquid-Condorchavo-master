package cl.uchile.dcc.citricliquid.model.unit;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents a player in the game 99.7% Citric Liquid. It was edited by Vicente Gatica.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater
 *     Muñoz</a>.
 * @version 2.0
 * @since 1.0
 */
public class Player extends AbstractUnit {
  private final Random random;
  private int normaLevel;
  private int wins;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name.
   * @param hp
   *     the initial (and max) hit points of the character.
   * @param atk
   *     the base damage the character does.
   * @param def
   *     the base defense of the character.
   * @param evd
   *     the base evasion of the character.
   */
  public Player(final String name, final int hp, final int atk, final int def,
                final int evd) {
    super(name, hp, atk, def, evd);
    normaLevel = 1;
    random = new Random();
  }

  /**
   * Set's the seed for this player's random number generator.
   *
   * <p>The random number generator is used for taking non-deterministic decisions, this method is
   * declared to avoid non-deterministic behaviour while testing the code.
   */
  public void setSeed(final long seed) {
    random.setSeed(seed);
  }

  /**
   * Returns a uniformly distributed random value in [1, 6].
   */
  public int roll() {
    return random.nextInt(6) + 1;
  }

  /**
   * Returns the current norma level.
   */
  public int getNormaLevel() {
    return normaLevel;
  }

  /**
   * Performs a norma clear action; the {@code norma} counter increases in 1.
   */
  public void normaClear() {
    if (normaLevel < 6) {
      normaLevel++; // normaLevel++ doesn't verify level 6 is the max level, so we add a condition
    }
  }

  /**
   * Sets the current character's hit points.
   *
   * <p>The character's hit points have a constraint to always be between 0 and maxHP, both
   * inclusive.
   */
  public void setCurrentHp(final int newHp) {
    this.currentHp = Math.max(Math.min(newHp, maxHp), 0);
    if (this.currentHp == 0) {
      System.out.println(this.name + " está K.O.");
    }
  }

  /**
   * Increases this player's wins count by a given amount.
   */
  public void increaseWinsBy(final int amount) {
    wins += amount;
  }

  /**
   * Checks if two object are "equal".
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Player player)) {
      return false;
    }
    return getMaxHp() == player.getMaxHp()
           && getAtk() == player.getAtk()
           && getDef() == player.getDef()
           && getEvd() == player.getEvd()
           && getStars() == player.getStars()
           && getNormaLevel() == player.getNormaLevel()
           && getCurrentHp() == player.getCurrentHp()
           && getName().equals(player.getName());
  }

  /**
   * Returns a copy of this character.
   */
  public Player copy() {
    return new Player(name, maxHp, atk, def, evd);
  }

  /**
   * Returns the amount of wins of the player.
   */
  public int getWins() {
    return wins;
  }

  /**
   * This method is executed when the actual player won against an opponent.
   */
  public void winAgainstPlayer(@NotNull Player player) {
    this.increaseWinsBy(2);
    player.defeatedByPlayer(this);
  }

  /**
   * This method is executed when the actual player lost against an opponent.
   */
  public void defeatedByPlayer(@NotNull Player player) {
    player.increaseStarsBy(this.getStars() / 2);
    this.reduceStarsBy(this.getStars() / 2);
  }

  /**
   * This method is executed when the actual player won against a unit.
   */
  public void winAgainstUnit(@NotNull Unit unit) {
    this.increaseStarsBy(unit.getStars());
    unit.defeatedByPlayer(this);
  }

  /**
   * This method is executed when the actual player lost against a unit.
   */
  public void defeatedByUnit(@NotNull Unit unit) {
    unit.winAgainstPlayer(this);
  }

  /**
   * This method is executed when two opponents have a battle.
   */
  public int playerBattle(@NotNull Player opponent) {
    //these prints will be an input when implemented
    System.out.println(this.name + ":, ¿Elige activar una carta?");
    System.out.println(opponent.name + ", ¿Elige activar una carta?");
    int attack = this.battleRoll();
    System.out.println("Continua la batalla... ");
    return attack;
  }

  /**
   * This method is executed when the actual player have a battle against a unit.
   */
  public int unitBattle(Unit unit) {
    //that will be an input when implemented
    System.out.println(this.name + ", ¿Elige activar una carta?");
    int attack = this.battleRoll();
    System.out.println("etc... ");
    return attack;
  }

  /**
   * This method is executed to roll in the battle.
   */
  public int battleRoll() {
    int roll = this.roll();
    System.out.print("El ataque inicial de " + this.name + " es: ");
    System.out.println(this.getAtk());
    System.out.print("El número sacado al lanzar el dado fue: ");
    System.out.println(roll);
    System.out.print("El nuevo ataque de " + this.name + " es: ");
    int attack = this.getAtk() + roll;
    System.out.println(attack);
    return attack;
  }
}
