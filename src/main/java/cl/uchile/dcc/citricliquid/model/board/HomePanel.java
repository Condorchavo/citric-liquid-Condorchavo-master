package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unit.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the home panel.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 1.0
 * @since 1.0
 */
public class HomePanel extends AbstractPanel {
  public HomePanel() {}

  @Override
  public String toString() {
    return "HomePanel";
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  @Override
  public void activatedBy(Player player) {
    applyHealTo(player);
    normaCheck(player);
  }

  /**
   * Restores a player's HP in 1.
   */
  private static void applyHealTo(final @NotNull Player player) {
    player.setCurrentHp(player.getCurrentHp() + 1);
  }

  /**
   * This method represents the normaCheck action.
   */
  private void normaCheck(final @NotNull Player player) {
    int norma = player.getNormaLevel();
    int stars = player.getStars();
    int wins = player.getWins();
    if (norma == 1 && stars >= 10) {
      player.normaClear();
    } else if (norma == 2 && (stars >= 30 || wins >= 2)) {
      player.normaClear();
    } else if (norma == 3 && (stars >= 70 || wins >= 5)) {
      player.normaClear();
    } else if (norma == 4 && (stars >= 120 || wins >= 9)) {
      player.normaClear();
    } else if (norma == 5 && (stars >= 200 || wins >= 14)) {
      player.normaClear();
    }
  }
}
