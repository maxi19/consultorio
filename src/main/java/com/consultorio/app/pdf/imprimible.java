package com.consultorio.app.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.ByteArrayOutputStream;

public interface imprimible {

    public void obtenerDocumento(Document document, ByteArrayOutputStream out) throws DocumentException;

}
