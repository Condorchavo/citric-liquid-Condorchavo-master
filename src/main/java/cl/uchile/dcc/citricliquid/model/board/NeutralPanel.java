package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unit.Player;

/**
 * Class created to represent the neutral panels.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 1.0
 * @since 1.0
 */
public class NeutralPanel extends AbstractPanel {

  public NeutralPanel() {

  }

  public String toString() {
    return "NeutralPanel";
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  @Override
  public void activatedBy(Player player) {}
}
