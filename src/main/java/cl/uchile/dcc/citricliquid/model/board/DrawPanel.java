package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unit.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the draw panel.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 2.0
 * @since 1.0
 */
public class DrawPanel extends AbstractPanel {

  public DrawPanel() {}

  /**
   * Returns the type of the current panel.
   */
  @Override
  public String toString() {
    return "DrawPanel";
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  @Override
  public void activatedBy(final @NotNull Player player) {
    // since we don´t implements the cards part, we only print the expected action for the panel
    System.out.println(player.getName() + " roba una carta y la agrega a su mazo");
  }
}
