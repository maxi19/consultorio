package com.consultorio.app.service.dto;
import com.consultorio.app.pdf.imprimible;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDto implements imprimible {

    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String documento;

    @NotBlank
    private String telefono;

    @NotNull
    private int sucursal;

    @NotNull
    private Calendar fechaTurno;

    @NotBlank
    private String codigoHora;

    @NotBlank
    private String horario;

    @Override
    public String toString() {
        return "ReservaDto{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            ", documento='" + documento + '\'' +
            ", telefono='" + telefono + '\'' +
            ", sucursal=" + sucursal +
            ", fechaTurno=" + fechaTurno +
            ", codigoHora='" + codigoHora + '\'' +
            ", horario='" + horario + '\'' +
            '}';
    }

    @Override
    public void obtenerDocumento(Document document, ByteArrayOutputStream out ) throws DocumentException {

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(60);
        table.setWidths(new int[]{1, 3, 3});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Id", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Name", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Population", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        PdfPCell cell;

        cell = new PdfPCell(new Phrase(this.getId().toString()));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(this.getNombre()));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(this.getSucursal())));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingRight(5);
        table.addCell(cell);

        PdfWriter.getInstance(document, out);
        document.open();
        document.add(table);
        document.close();
    }
}
