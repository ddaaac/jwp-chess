package wooteco.chess.domain.piece.strategy;

import wooteco.chess.domain.board.Column;
import wooteco.chess.domain.board.Path;
import wooteco.chess.domain.board.Position;
import wooteco.chess.domain.piece.Side;

public class KingStrategy implements Strategy {
    final int DIAGONAL_ONE_SQUARED = 2;

    @Override
    public boolean shouldBePlacedOn(final Position position, final Side side) {
        return isNotPawn(position, side)
            && position.isOn(Column.E);
    }

    @Override
    public boolean isMovableWithin(final Path path) {
        return path.distanceSquare() <= DIAGONAL_ONE_SQUARED
            && (path.isEndEmpty() || path.isEnemyOnEnd());
    }
}
