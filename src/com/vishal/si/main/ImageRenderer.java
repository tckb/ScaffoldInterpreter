package com.vishal.si.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.interfaces.IMolecule;
import org.openscience.cdk.layout.StructureDiagramGenerator;
import org.openscience.cdk.renderer.AtomContainerRenderer;
import org.openscience.cdk.renderer.RendererModel;
import org.openscience.cdk.renderer.font.AWTFontManager;
import org.openscience.cdk.renderer.generators.BasicAtomGenerator;
import org.openscience.cdk.renderer.generators.BasicBondGenerator;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.BackgroundColor;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.ZoomFactor;
import org.openscience.cdk.renderer.generators.IGeneratorParameter;
import org.openscience.cdk.renderer.visitor.AWTDrawVisitor;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smiles.SmilesParser;

public class ImageRenderer {

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    private int width = 0;
    private int height = 0;

    public Image getImageFromSmile(String smiles) throws InvalidSmilesException, CDKException {


        Rectangle drawArea = new Rectangle(this.width, this.height);
        Image image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        SmilesParser smilesParser = new SmilesParser(SilentChemObjectBuilder.getInstance());
        IMolecule molecule = smilesParser.parseSmiles(smiles);
        StructureDiagramGenerator sdg = new StructureDiagramGenerator();
        sdg.setMolecule(molecule);
        sdg.generateCoordinates();
        molecule = sdg.getMolecule();
        
        
        List generators = new ArrayList();
        generators.add(new BasicBondGenerator());
        generators.add(new BasicAtomGenerator());
        BasicSceneGenerator scene = new BasicSceneGenerator();
        List<IGeneratorParameter<?>> params = scene.getParameters();
        ((BackgroundColor) params.get(0)).setValue(UIManager.getDefaults().getColor("Menu.background"));
        generators.add(scene);

        AtomContainerRenderer renderer = new AtomContainerRenderer(generators, new AWTFontManager());

        renderer.setup(molecule, drawArea);
        Rectangle dim = renderer.calculateDiagramBounds(molecule);
        
        RendererModel model = renderer.getRenderer2DModel();
        
        
        model.setNotification(true);
        model.set(ZoomFactor.class, (double) 0.5* (getArea(width, height)) / (getArea(dim.width, dim.height)));
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(javax.swing.UIManager.getDefaults().getColor("Menu.background"));
        g2.setBackground(UIManager.getDefaults().getColor("Menu.background"));
        g2.fillRect(0, 0, this.width, this.height);

        renderer.paint(molecule, new AWTDrawVisitor(g2));


        return image;
    }

    private double getArea(int w, int h) {
        return 2 * w * h / (w + h);
    }

    public Icon getIconFromSmiles(String smiles) throws InvalidSmilesException, CDKException {

        return new ImageIcon(getImageFromSmile(smiles));
    }
}
