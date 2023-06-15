/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ema
 */

public class Trabajadores {


     private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void main(String[] args) throws DocumentException {
        // Crear un libro de Excel
       XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Empleados");

        for (int i = 0; i < 7; i++) {
            int numEmpleado = i + 1;

            
            
            
            String cedula = Nombre(numEmpleado);
            String nombre = Cedula(numEmpleado);
            String genero = Genero(numEmpleado);
            double salarioMes = obtenerSalarioMes(numEmpleado);
            int horasExtras = obtenerHorasExtras(numEmpleado);

            // el dinero a pagar por las horas extras
            double salariosExtra = (salarioMes / 30) * 1.5 * horasExtras;
            
            
            
            

            // aguinaldo
            double aguinaldo = (salarioMes * 12 + salariosExtra) / 12;
            
            
            

            // Agregar al archivo de Excel
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);

            Cell cell = row.createCell(0);
            cell.setCellValue(numEmpleado);

            cell = row.createCell(1);
            cell.setCellValue(cedula);

            cell = row.createCell(2);
            cell.setCellValue(nombre);

            cell = row.createCell(3);
            cell.setCellValue(genero);

            cell = row.createCell(4);
            cell.setCellValue(salarioMes);

            cell = row.createCell(5);
            cell.setCellValue(horasExtras);

            cell = row.createCell(6);
            cell.setCellValue(salariosExtra);

            cell = row.createCell(7);
            cell.setCellValue(aguinaldo);
        }

        // Guardar el archivo
        try (FileOutputStream fileOut = new FileOutputStream("ReporteEmpleados.xlsx")) {
            workbook.write(fileOut);
            System.out.println(" reporte en formato Excel se ha creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el reporte en Excel: ");
        }

          //  reporte en PDF
        try (FileOutputStream fileOut = new FileOutputStream("ReporteEmpleados.pdf")) {
            Document document = new Document();
            PdfWriter.getInstance(document, fileOut);

            document.open();

            
            
            //  título
            Font titleFont = FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 20, Font.NORMAL);
            Paragraph title = new Paragraph("INFORME DE EMPLEADOS", (com.itextpdf.text.Font) titleFont);
            title.setAlignment(Element.BODY);
            document.add(title);

            
            //  fecha de creación del reporte
            LocalDate fechaActual = LocalDate.now();
            String fechaCreacion = fechaActual.format(DATE_FORMATTER);
            Paragraph fecha = new Paragraph("Fecha de creación del reporte: " + fechaCreacion);
            fecha.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            document.add(fecha);

            // nombre del autor
            Paragraph autor = new Paragraph("Autor: emanuel aguilar");
            autor.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            document.add(autor);

            //  tabla con la información de los empleados
            PdfPTable table = new PdfPTable(8);
            addTableHeader(table);
            addRows(table, sheet);
            document.add(table);

            document.close();
            System.out.println("El reporte en PDF ha sido creadi correctamente.");
        } catch (IOException | DocumentException e) {
            System.out.println("Error al generar el reporte PDF: " + e.getMessage());
        }
    
    }

    private static String Cedula(int numeroEmpleado) {
        while (true) {
            String cedula = JOptionPane.showInputDialog(" cédula del empleado #" + numeroEmpleado);
            if (cedula.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ingresar la cédula del empleado.");
            } else {
                return cedula;
            }
        }
    }

    private static String Nombre(int numeroEmpleado) {
        while (true) {
            String nombre = JOptionPane.showInputDialog(" nombre del empleado " + numeroEmpleado);
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, " ingresar el nombre del empleado.");
            } else {
                return nombre;
            }
        }
    }

    private static String Genero(int numeroEmpleado) {
        
        String gen = JOptionPane.showInputDialog(null, numeroEmpleado + "cual es el género del empleado ");
        
        if (gen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ingrese el género del empleado.");
            return Genero(numeroEmpleado);
        }
        return gen;
    }

    private static double obtenerSalarioMes(int numeroEmpleado) {
        while (true) {
            try {
                double salarioMensual = Double.parseDouble(JOptionPane.showInputDialog(
                        " salario mensual del empleado " + numeroEmpleado));
                if (salarioMensual <= 0) {
                    JOptionPane.showMessageDialog(null, "El salario debe ser mayor a 0.");
                } else {
                    return salarioMensual;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El salario tiene que ser un valor válido.");
            }
        }
    }

    private static int obtenerHorasExtras(int numeroEmpleado) {
        
        while (true) {

            try {
                int horasExtrasAnuales = Integer.parseInt(JOptionPane.showInputDialog("el número de horas extras anuales trabajadas" + numeroEmpleado));
                if (horasExtrasAnuales < 0) {

                    JOptionPane.showMessageDialog(null, "El número de horas extras anuales tienen que ser mayor o igual a 0.");
                } else {

                    return horasExtrasAnuales;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de horas extras debe ser un valor válido.");
            }
        }
    }
    
    
    private static void addTableHeader(PdfPTable table) {
        String[] headers = { "Número", "Cédula", "Nombre", "Género", "Salario Mensual", "Horas Extras", "Salarios Extra", "Aguinaldo" };

        
        for (String header : headers) {
            PdfPCell cell = new PdfPCell();
            
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            cell.setPadding(5);
            cell.setPhrase(new Phrase(header));
    
            
            table.addCell(cell);
        }
    }

    
    private static void addRows(PdfPTable table, Sheet sheet) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                table.addCell(cell.toString());
            }
        }
    }

}

