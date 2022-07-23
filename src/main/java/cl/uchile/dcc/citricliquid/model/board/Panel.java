package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unit.Player;
import java.util.List;

/**
 * Interface for the panels.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 1.0
 * @since 1.0
 */
public interface Panel {
  /**
   * Returns the type of this panel.
   */
  String toString();

  /**
   * Returns a copy of this panel's next ones.
   */
  List<AbstractPanel> getNextPanels();

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  void addNextPanel(final AbstractPanel panel);

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  void activatedBy(final Player player);
}
