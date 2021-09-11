package com.consultorio.app.pdf;

import com.itextpdf.text.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class PdfComponent {

   private static final Logger log = LoggerFactory.getLogger(PdfComponent.class);

    public static ByteArrayInputStream generarPdf(imprimible imprimible) {
        Document document = new Document();
         ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            imprimible.obtenerDocumento(document, out);
        }catch (DocumentException ex) {
            log.error("Error occurred: {0}", ex);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

}
