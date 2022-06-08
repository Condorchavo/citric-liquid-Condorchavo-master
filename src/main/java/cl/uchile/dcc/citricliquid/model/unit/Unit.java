package cl.uchile.dcc.citricliquid.model.unit;

import org.jetbrains.annotations.NotNull;

/**
 * Interface for the boss and wild units.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 1.0
 * @since 1.0
 */
public interface Unit {
  public void defeatedByPlayer(@NotNull Player player);

  public boolean equals(final Object o);

  public void winAgainstPlayer(Player player);


  int getStars();

  void reduceStarsBy(int stars);
}
