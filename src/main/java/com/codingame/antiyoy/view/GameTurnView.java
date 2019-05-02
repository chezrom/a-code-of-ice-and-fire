package com.codingame.antiyoy.view;

import com.codingame.gameengine.module.entities.Entity;

import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.codingame.gameengine.module.entities.Group;
import com.codingame.gameengine.module.entities.Text;
import com.codingame.gameengine.module.tooltip.TooltipModule;

import java.util.concurrent.atomic.AtomicInteger;

import static com.codingame.antiyoy.view.Constants.*;

public class GameTurnView extends AbstractView {
    private Group group;

    private AtomicInteger gameTurn;
    private AtomicInteger playerTurn;

    private Text text;

    public GameTurnView(GraphicEntityModule entityModule, TooltipModule tooltipModule, AtomicInteger gameTurn, AtomicInteger playerTurn) {
        super(entityModule, tooltipModule);
        this.gameTurn = gameTurn;
        this.playerTurn= playerTurn;
        createGameTurnView();
    }

    public void createGameTurnView() {
        text = this.entityModule.createText("")
                .setAnchor(0.5)
                .setFillColor(0xffffff)
                .setFontSize(60)
                .setStrokeColor(0x000000)
                .setStrokeThickness(4.0)
                .setX(LEFT_PANEL_WIDTH / 2 + 75)
                .setY(0);

        group = entityModule.createGroup()
                .setScale(1)
                .setX(0)
                .setY(473 + 117 / 2);
        group.add(text);
    }

    public void updateView() {
        this.text
            .setText("Turn " + gameTurn.intValue())
            .setFillColor(getTurnColor(playerTurn.intValue()));
    }

    public Entity getEntity() {
        return group;
    }

}
