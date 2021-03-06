package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unit.Player;

/**
 * Class that represents the boss panel.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 1.0
 * @since 1.0
 */
public class BossPanel extends AbstractPanel {
  public BossPanel() {}

  @Override
  public String toString() {
    return "BossPanel";
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  @Override
  public void activatedBy(Player player) {
    System.out.println(player.getName() + " entra en batalla con boss unit");
  }
}
