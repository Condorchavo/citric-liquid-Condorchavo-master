package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unit.Player;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a panel in the board of the game. Edited by Vicente Gatica.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>.
 * @version 2.0
 * @since 1.0
 */
public abstract class AbstractPanel {
  private final List<AbstractPanel> nextPanels = new ArrayList<>();

  public AbstractPanel() {}

  /**
   * Returns the type of this panel.
   */
  public abstract String toString();

  /**
   * Returns a copy of this panel's next ones.
   */
  public List<AbstractPanel> getNextPanels() {
    return List.copyOf(nextPanels);
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  public void addNextPanel(final AbstractPanel panel) {
    nextPanels.add(panel);
  }

  /**
   * Executes the appropriate action to the player according to this panel's type.
   */
  public abstract void activatedBy(final Player player);
}
