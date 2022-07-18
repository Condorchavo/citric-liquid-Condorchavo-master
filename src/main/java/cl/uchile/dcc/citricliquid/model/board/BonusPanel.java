package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unit.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the bonus panel.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 2.0
 * @since 1.0
 */
public class BonusPanel extends AbstractPanel {
  public BonusPanel() {}

  /**
   * Returns the type of the current panel.
   */
  @Override
  public String toString() {
    return "BonusPanel";
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  @Override
  public void activatedBy(final Player player) {
    applyBonusTo(player);
  }

  /**
   * Reduces the player's star count by the D6 roll multiplied by the maximum between the player's
   * norma level and three.
   */
  private static void applyBonusTo(final @NotNull Player player) {
    player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
  }
}
