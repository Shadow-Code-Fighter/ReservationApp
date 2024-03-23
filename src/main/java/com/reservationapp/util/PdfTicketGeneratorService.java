package com.reservationapp.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.reservationapp.entity.Passenger;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfTicketGeneratorService {

    /**
     * Generates a PDF ticket for a passenger's reservation.
     *
     * @param passenger The passenger for whom the ticket is generated.
     * @param fromLocation The starting location of the journey.
     * @param toLocation The destination location of the journey.
     * @param fromDate The date of the journey.
     * @return The byte array representing the generated PDF ticket.
     */
    public byte[] generateTicket(Passenger passenger,String fromLocation,String toLocation,String fromDate) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        try {
            // Create a PDF writer to write the document to the output stream
            PdfWriter.getInstance(document, outputStream);
            // Open the document for writing
            document.open();
            // Add ticket information to the document
            document.add(new Paragraph("Ticket Information:"));
            document.add(new Paragraph("Name: " + passenger.getFirstName() + " " + passenger.getLastName()));
            document.add(new Paragraph("Email: " + passenger.getEmail()));
            document.add(new Paragraph("Mobile: " + passenger.getMobile()));
            document.add(new Paragraph("Bus Number: " + passenger.getBusId()));
            document.add(new Paragraph("Route ID: " + passenger.getRouteId()));
            document.add(new Paragraph("From Location: " + fromLocation));
            document.add(new Paragraph("To Location: " + toLocation));
            document.add(new Paragraph("From Date: " + fromDate));
            // Close the document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return the byte array containing the generated PDF ticket
        return outputStream.toByteArray();
    }
}
