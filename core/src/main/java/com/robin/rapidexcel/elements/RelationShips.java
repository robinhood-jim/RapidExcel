package com.robin.rapidexcel.elements;

import com.robin.rapidexcel.writer.XMLWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RelationShips implements IWriteableElements {
    private List<RelationShip> relationShips=new ArrayList<>();


    public void addRelationShip(RelationShip relationShip){
        relationShips.add(relationShip);
    }

    public List<RelationShip> getRelationShips() {
        return relationShips;
    }

    @Override
    public void writeOut(XMLWriter writer) throws IOException {
        beginPart(writer,"");
    }

}
