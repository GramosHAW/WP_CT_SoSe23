import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.io.*;

public class CoverageCheckerGUI extends JFrame {
    private JRadioButton mcDcRadio;
    private JRadioButton mmbuRadio;
    private JCheckBox bothCheckBox;
    private JTextArea resultTextArea;

    public CoverageCheckerGUI() {
        setTitle("Coverage Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

// Radio buttons
        mcDcRadio = new JRadioButton("MC/DC");
        mmbuRadio = new JRadioButton("MMBÜ");

// Checkbox
        bothCheckBox = new JCheckBox("Both");

// Result text area
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

// Button group for radio buttons
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(mcDcRadio);
        radioButtonGroup.add(mmbuRadio);

// Drag and drop support
        DropTarget dropTarget = new DropTarget(this, new MarkdownDropTargetListener());

// Add components to the frame
        add(mcDcRadio);
        add(mmbuRadio);
        add(bothCheckBox);
        add(new JScrollPane(resultTextArea));

        pack();
        setVisible(true);
    }

    private class MarkdownDropTargetListener implements DropTargetListener {
        @Override
        public void dragEnter(DropTargetDragEvent dtde) {
// Highlight the frame to indicate that dropping is possible
            CoverageCheckerGUI.this.getContentPane().setBackground(Color.LIGHT_GRAY);
        }

        @Override
        public void dragExit(DropTargetEvent dte) {
// Restore the frame's background color
            CoverageCheckerGUI.this.getContentPane().setBackground(null);
        }

        @Override
        public void dragOver(DropTargetDragEvent dtde) {
// Not used
        }

        @Override
        public void drop(DropTargetDropEvent dtde) {
            try {
// Get the dropped data flavor
                DataFlavor flavor = dtde.getCurrentDataFlavors()[0];

// Check if the dropped data is a file
                if (flavor.isFlavorJavaFileListType()) {
// Accept the drop
                    dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

// Get the dropped files
                    java.util.List<File> fileList = (java.util.List<File>) dtde.getTransferable().getTransferData(flavor);

// Process the dropped files
                    for (File file : fileList) {
                        String markdownContent = readMarkdownFile(file);

                        if (markdownContent != null) {
                            boolean mcDcSelected = mcDcRadio.isSelected();
                            boolean mmbuSelected = mmbuRadio.isSelected();
                            boolean bothSelected = bothCheckBox.isSelected();

                            if (mcDcSelected || bothSelected) {
                                String mcDcResult = performMcDcCoverageCheck(markdownContent);
                                resultTextArea.append("MC/DC Coverage Check Result:\n" + mcDcResult + "\n\n");
                            }

                            if (mmbuSelected || bothSelected) {
                                String mmbuResult = performMmbuCoverageCheck(markdownContent);
                                resultTextArea.append("MMBÜ Coverage Check Result:\n" + mmbuResult + "\n\n");
                            }
                        } else {
                            resultTextArea.setText("Error reading the markdown file.");
                        }
                    }

// Indicate that the drop is complete
                    dtde.dropComplete(true);
                } else {
// Reject the drop if the data is not a file
                    dtde.rejectDrop();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
// Restore the frame's background color
                CoverageCheckerGUI.this.getContentPane().setBackground(null);
            }
        }

        @Override
        public void dropActionChanged(DropTargetDragEvent dtde) {
// Not used
        }
    }

    private String readMarkdownFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String performMcDcCoverageCheck(String markdownContent) {
        StringBuilder result = new StringBuilder();

// Split the markdown content into lines
        String[] lines = markdownContent.split("\\r?\\n");

// Iterate over each line
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] cells = line.split("\\|");

            int markedCells = 0;

// Iterate over each cell in the line
            for (int j = 1; j < cells.length - 1; j++) {
                String cell = cells[j].trim();

// Check if the cell is marked
                if (!cell.isEmpty() && !cell.equals("-")) {
                    markedCells++;
                }
            }

// Check if at least two cells are marked in the line
            if (markedCells >= 2) {
                result.append("Line ").append(i + 1).append(": ").append(line).append("\n");
            }
        }

// Return the result
        if (result.length() > 0) {
            return result.toString();
        } else {
            return "No lines with at least two marked cells found.";
        }
    }

    private String performMmbuCoverageCheck(String markdownContent) {
// Implement the MMBÜ coverage check logic here

        StringBuilder result = new StringBuilder();

// Split the markdown content into lines
        String[] lines = markdownContent.split("\\r?\\n");

// Iterate over each line
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] cells = line.split("\\|");

            int markedCells = 0;

// Iterate over each cell in the line
            for (int j = 1; j < cells.length - 1; j++) {
                String cell = cells[j].trim();

// Check if the cell is marked
                if (!cell.isEmpty() && !cell.equals("-")) {
                    markedCells++;
                }
            }

// Check if at least two cells are marked in the line
            if (markedCells >= 2) {
                result.append("Line ").append(i + 1).append(": ").append(line).append("\n");
            }
        }

// Return the result
        if (result.length() > 0) {
            return result.toString();
        } else {
            return "No lines with at least two marked cells found.";
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CoverageCheckerGUI();
            }
        });
    }
}
