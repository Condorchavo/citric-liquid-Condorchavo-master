package cl.uchile.dcc.citricliquid.model.unit;

import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the boss units.
 *
 * @author <a href="mailto:vicente.gatica@ug.uchile.cl">Vicente Gatica Perez</a>.
 * @version 2.0
 * @since 1.0
 */
public class BossUnit extends AbstractUnit implements Enemies {

  /**
   * Creates a new character.
   *
   * @param name the character's name.
   * @param hp   the initial (and max) hit points of the character.
   * @param atk  the base damage the character does.
   * @param def  the base defense of the character.
   * @param evd  the base evasion of the character.
   */
  public BossUnit(String name, int hp, int atk, int def, int evd) {
    super(name, hp, atk, def, evd);
  }

  /**
   * Checks if two object are "equal".
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BossUnit bossUnit)) {
      return false;
    }
    return getMaxHp() == bossUnit.getMaxHp()
        && getAtk() == bossUnit.getAtk()
        && getDef() == bossUnit.getDef()
        && getEvd() == bossUnit.getEvd()
        && getCurrentHp() == bossUnit.getCurrentHp()
        && getName().equals(bossUnit.getName())
        && getStars() == bossUnit.getStars();
  }

  /**
   * This method is executed when the boss unit lost against an opponent.
   */
  @Override
  public void defeatedByPlayer(@NotNull Player player) {
    player.increaseWinsBy(3);
    this.reduceStarsBy(this.getStars());
  }

  /**
   * This method is executed when the boss unit won against an opponent.
   */
  public void winAgainstPlayer(@NotNull Player player) {
    this.increaseStarsBy(player.getStars() / 2);
    player.reduceStarsBy(player.getStars() / 2);
  }
}
