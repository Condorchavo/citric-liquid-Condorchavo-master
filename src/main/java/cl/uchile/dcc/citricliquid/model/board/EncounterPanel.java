package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unit.Player;

/**
 * Class that represents the encounter panel.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 2.0
 * @since 1.0
 */
public class EncounterPanel extends AbstractPanel {

  public EncounterPanel() {}

  /**
   * Returns the type of the current panel.
   */
  @Override
  public String toString() {
    return "EncounterPanel";
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  @Override
  public void activatedBy(Player player) {
    System.out.println(player.getName() + " entra en batalla con wild unit");
  }
}
