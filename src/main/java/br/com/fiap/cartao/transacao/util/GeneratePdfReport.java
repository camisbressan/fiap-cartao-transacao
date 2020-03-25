package br.com.fiap.cartao.transacao.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.fiap.cartao.transacao.dto.TransacaoDTO;

public class GeneratePdfReport {

	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

	public static ByteArrayInputStream extratoTransacoesPorAluno(List<TransacaoDTO> transacoes, Integer idAluno) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, out);
			document.open();

			Font title = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD);

			// Título do extrato
			Paragraph paragraph = new Paragraph();
			paragraph.add(new Phrase("Extrato do Aluno Id: " + idAluno, title));
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.add(new Paragraph(" "));
			document.add(paragraph);

			// Dados do extrato
			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(80);
			table.setWidths(new int[] { 3, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Id Transação", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Valor Compra", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Data e Hora da Compra", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			for (TransacaoDTO transacao : transacoes) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(transacao.getId().toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("R$ " + String.valueOf(transacao.getValorCompra())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
				String dataFormatada = transacao.getDataCompra().format(formato);

				cell = new PdfPCell(new Phrase(dataFormatada));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);
			}

			document.add(table);
			document.close();

		} catch (DocumentException ex) {

			logger.error("Error occurred: {0}", ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	public static ByteArrayInputStream extratoTodasTransacoes(List<TransacaoDTO> transacoes) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, out);
			document.open();

			Font title = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD);

			// Título do extrato
			Paragraph paragraph = new Paragraph();
			paragraph.add(new Phrase("Extrato de Todas as Transações", title));
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.add(new Paragraph(" "));
			document.add(paragraph);

			// Dados do extrato
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(90);
			table.setWidths(new int[] { 3, 3, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Id Transação", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Id Aluno", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Valor Compra", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Data e Hora da Compra", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			for (TransacaoDTO transacao : transacoes) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(transacao.getId().toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(transacao.getIdAluno().toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("R$ " + String.valueOf(transacao.getValorCompra())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
				String dataFormatada = transacao.getDataCompra().format(formato);

				cell = new PdfPCell(new Phrase(dataFormatada));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);
			}

			document.add(table);
			document.close();

		} catch (DocumentException ex) {

			logger.error("Error occurred: {0}", ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}