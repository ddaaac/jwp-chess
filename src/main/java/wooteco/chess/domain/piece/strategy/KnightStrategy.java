package wooteco.chess.domain.piece.strategy;

import wooteco.chess.domain.board.Column;
import wooteco.chess.domain.board.Path;
import wooteco.chess.domain.board.Position;
import wooteco.chess.domain.piece.Side;

public class KnightStrategy implements Strategy {
    final int KNIGHT_PATH_LENGTH_SQUARED = 5;

    @Override
    public boolean shouldBePlacedOn(final Position position, final Side side) {
        return isNotPawn(position, side)
            && (position.isOn(Column.B) || position.isOn(Column.G));
    }

    @Override
    public boolean isMovableWithin(final Path path) {
        return path.distanceSquare() == KNIGHT_PATH_LENGTH_SQUARED
            && (path.isEndEmpty() || path.isEnemyOnEnd());
    }
}
