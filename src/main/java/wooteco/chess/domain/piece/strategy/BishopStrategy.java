package wooteco.chess.domain.piece.strategy;

import wooteco.chess.domain.board.Column;
import wooteco.chess.domain.board.Path;
import wooteco.chess.domain.board.Position;
import wooteco.chess.domain.piece.Side;

public class BishopStrategy implements Strategy {
    @Override
    public boolean shouldBePlacedOn(final Position position, final Side side) {
        return isNotPawn(position, side)
            && (position.isOn(Column.C) || position.isOn(Column.F));
    }

    @Override
    public boolean isMovableWithin(final Path path) {
        return path.isDiagonal()
            && (path.isEndEmpty() || path.isEnemyOnEnd())
            && !path.isBlocked();
    }
}
