package com.pokemon.components;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.pokemon.model.PokemonModel;

@Component

public class PDF {
    public void PDFPokemon(List<PokemonModel> lista) {
        Document doc = null;
        
        try {
            doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(".\\src\\main\\resources\\static\\pdf\\equipo.pdf"));
            Table table = new Table(1);
            table.setWidth(150);
            Cell celda = new Cell("Pokemon");
            table.addCell(celda);
            
            table.addCell(new Phrase("Nombre pokemon"));
            table.addCell(new Phrase("Ataque pokemon"));
            table.addCell(new Phrase("Defensa pokemon"));
            table.addCell(new Phrase("Foto pokemon"));
            table.endHeaders();
            
            for(PokemonModel em: lista) {
                table.addCell(em.getNombre());
                table.addCell(Integer.toString(em.getAtaque()));
                table.addCell(Integer.toString(em.getDefensa()));
                table.addCell(em.getFoto());
            }
            doc.open();
            doc.add(table);
            doc.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
