package cl.uchile.dcc.citricliquid.model.unit;

import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the wild units.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 1.0
 * @since 1.0
 */
public class WildUnit extends AbstractUnit implements Unit {

  /**
   * Creates a new character.
   *
   * @param name the character's name.
   * @param hp   the initial (and max) hit points of the character.
   * @param atk  the base damage the character does.
   * @param def  the base defense of the character.
   * @param evd  the base evasion of the character.
   */
  public WildUnit(String name, int hp, int atk, int def, int evd) {
    super(name, hp, atk, def, evd);
  }

  @Override
  public void defeatedByPlayer(@NotNull Player player) {
    player.increaseWinsBy(1);
    this.reduceStarsBy(this.getStars());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final WildUnit wildUnit)) {
      return false;
    }
    return getMaxHp() == wildUnit.getMaxHp()
        && getAtk() == wildUnit.getAtk()
        && getDef() == wildUnit.getDef()
        && getEvd() == wildUnit.getEvd()
        && getCurrentHp() == wildUnit.getCurrentHp()
        && getName().equals(wildUnit.getName())
        && getStars() == wildUnit.getStars();
  }

  @Override
  public void winAgainstPlayer(@NotNull Player player) {
    this.increaseStarsBy(player.getStars() / 2);
    player.reduceStarsBy(player.getStars() / 2);
  }
}
