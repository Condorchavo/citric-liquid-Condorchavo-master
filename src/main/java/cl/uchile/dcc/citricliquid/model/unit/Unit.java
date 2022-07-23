package cl.uchile.dcc.citricliquid.model.unit;

import org.jetbrains.annotations.NotNull;

public interface Unit {
  /**
   * Returns the character's name.
   */
  String getName();

  /**
   * Returns the character's max hit points.
   */
  int getMaxHp();

  /**
   * Returns the current character's attack points.
   */
  int getAtk();

  /**
   * Returns the current character's defense points.
   */
  int getDef();

  /**
   * Returns the current character's evasion points.
   */
  int getEvd();

  /**
   * Returns the current hit points of the character.
   */
  int getCurrentHp();

  /**
   * Increases this player's star count by an amount.
   */
  void increaseStarsBy(final int amount);

  /**
   * Reduces this player's star count by a given amount.
   *
   * <p>The star count will must always be greater or equal to 0
   */
  void reduceStarsBy(final int amount);

  /**
   * Returns this player's star count.
   */
  int getStars();

  /**
   * This method is executed when a player won the actual unit.
   */
  void defeatedByPlayer(@NotNull Player player);
}
