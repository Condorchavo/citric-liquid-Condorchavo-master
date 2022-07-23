package cl.uchile.dcc.citricliquid.model.unit;

import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the units (player and enemies) of each game.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 2.0
 * @since 1.0
 */
public abstract class AbstractUnit implements Unit {
  protected final String name;
  protected final int maxHp;
  protected final int atk;
  protected final int def;
  protected final int evd;
  protected int currentHp;
  protected int stars;

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
  public AbstractUnit(final String name, final int hp, final int atk, final int def,
                final int evd) {
    this.name = name;
    this.maxHp = this.currentHp = hp;
    this.atk = atk;
    this.def = def;
    this.evd = evd;
  }

  /**
   * Returns the character's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the character's max hit points.
   */
  public int getMaxHp() {
    return maxHp;
  }

  /**
   * Returns the current character's attack points.
   */
  public int getAtk() {
    return atk;
  }

  /**
   * Returns the current character's defense points.
   */
  public int getDef() {
    return def;
  }

  /**
   * Returns the current character's evasion points.
   */
  public int getEvd() {
    return evd;
  }

  /**
   * Returns the current hit points of the character.
   */
  public int getCurrentHp() {
    return currentHp;
  }

  /**
   * Increases this player's star count by an amount.
   */
  public void increaseStarsBy(final int amount) {
    stars += amount;
  }

  /**
   * Reduces this player's star count by a given amount.
   *
   * <p>The star count will must always be greater or equal to 0
   */
  public void reduceStarsBy(final int amount) {
    stars = Math.max(0, stars - amount);
  }

  /**
   * Returns this player's star count.
   */
  public int getStars() {
    return stars;
  }

  /**
   * This method is executed when a player won the actual unit.
   */
  public abstract void defeatedByPlayer(@NotNull Player player);
}
