package cl.uchile.dcc.citricliquid.model.unit;

import org.jetbrains.annotations.NotNull;

/**
 * Interface for the boss and wild units.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 2.0
 * @since 1.0
 */
public interface Unit {

  /**
   * This method is executed when the actual unit lost against other player.
   */
  public void defeatedByPlayer(@NotNull Player player);

  /**
   * Checks if two units are "equal".
   */
  public boolean equals(final Object o);

  /**
   * It does the changes when the actual unit won against the player 2.
   */
  public void winAgainstPlayer(Player player);

  /**
   * Returns the amount of stars the current unit have.
   */
  int getStars();

  /**
   * Decreases the amount of stars of the current unit.
   */
  void reduceStarsBy(int stars);
}
