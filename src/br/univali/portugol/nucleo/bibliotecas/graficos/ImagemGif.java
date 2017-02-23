/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.bibliotecas.graficos;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author noschang
 */
public final class ImagemGif extends Imagem
{
    private static final int TAMANHO_BUFFER = 131072; // 128 KB
    
    private final ImageReader leitorGif;
    private final MetadadosGif metadados;
    
    private int indiceQuadroAtual;
    private long drawTime = 0;

    public ImagemGif(File arquivo) throws IOException
    {
        byte[] bytesImagem = copiarParaMemoria(arquivo);
        
         imprimirInformacoesGif(bytesImagem);
        
        leitorGif = criarLeitorGif(bytesImagem);        
        metadados = lerMetadadosGif();
    }    
    
    @Override
    public BufferedImage getImagem()
    {
        if (System.currentTimeMillis() - drawTime >= getGifDelay() * 10)
        {
            nextImage();
            drawTime = System.currentTimeMillis();            
        }
        else if(drawTime == 0)
        {
           drawTime = System.currentTimeMillis();
        }
        
        return Utils.criarImagemCompativel(getActualImage());
    }

    public BufferedImage getActualImage()
    {
        //return gifFrames.get(actualImage).imagem;
        throw new UnsupportedOperationException("Não implementado");
    }

    public int getActualNumber()
    {
//        return actualImage;
        throw new UnsupportedOperationException("Não implementado");
    }



    public void nextImage()
    {
//        actualImage = (actualImage + 1) % gifFrames.size();
        throw new UnsupportedOperationException("Não implementado");
    }    
    
    public int getGifDelay()
    {
//        return gifFrames.get(actualImage).intervalo;
        throw new UnsupportedOperationException("Não implementado");
    }

    public int getLargura()
    {
        return metadados.largura;
    }

    public int getAltura()
    {
        return metadados.altura;
    }

    public int getNumeroFrames()
    {
        return metadados.numeroFrames;
    }

    public Color getCorFundo()
    {
        return metadados.corFundo;
    }
    
    public int getIndiceQuadroAtual()
    {
        return metadados.indiceQuadroAtual;
    }
    
    public void setIndiceQuadroAtual(int indice)
    {
        metadados.indiceQuadroAtual = indice;

        throw new UnsupportedOperationException("Não implementado");
    }
    
    private ImageReader criarLeitorGif(byte[] bytesImagem) throws IOException
    {
        ImageReader leitor = (ImageReader) ImageIO.getImageReadersByFormatName("gif").next();
        leitor.setInput(ImageIO.createImageInputStream(new ByteArrayInputStream(bytesImagem)));
        
        return leitor;
    }
    
    private byte[] copiarParaMemoria(File arquivo) throws IOException
    {
        int bytesLidos;
        byte[] buffer = new byte[TAMANHO_BUFFER];
        
        try (FileInputStream is = new FileInputStream(arquivo); ByteArrayOutputStream baos = new ByteArrayOutputStream(TAMANHO_BUFFER))
        {
            while ((bytesLidos = is.read(buffer, 0, buffer.length)) > 0)
            {
                baos.write(buffer, 0, bytesLidos);
            }
            
            return baos.toByteArray();
        }
    }
    
    private void imprimirInformacoesGif(byte[] bytesImagem)
    {
        String unit = "bytes";
        double length = bytesImagem.length;
        
        if (length > 1024)
        {
            length = length / 1024.0;
            unit = "kylobytes";
        }
        
        if (length > 1024)
        {
            length = length / 1024.0;
            unit = "megabytes";
        }
        
        if (length > 1024)
        {
            length = length / 1024.0;
            unit = "gigabytes";
        }
        
        System.out.println("GIF carregado, tamanho em memória: " + length + " " + unit);
    }
    
    private MetadadosGif lerMetadadosGif() throws IOException
    {
        MetadadosGif metadadosGif = new MetadadosGif();
        metadadosGif.numeroFrames = leitorGif.getNumImages(true);
        
        IIOMetadata metadata = leitorGif.getStreamMetadata();
        
        if (metadata != null)
        {
            IIOMetadataNode globalRoot = (IIOMetadataNode) metadata.getAsTree(metadata.getNativeMetadataFormatName());
            NodeList globalColorTable = globalRoot.getElementsByTagName("GlobalColorTable");
            NodeList globalScreeDescriptor = globalRoot.getElementsByTagName("LogicalScreenDescriptor");
            
            if (globalScreeDescriptor != null && globalScreeDescriptor.getLength() > 0)
            {
                IIOMetadataNode screenDescriptor = (IIOMetadataNode) globalScreeDescriptor.item(0);
                
                if (screenDescriptor != null)
                {
                    metadadosGif.largura = Integer.parseInt(screenDescriptor.getAttribute("logicalScreenWidth"));
                    metadadosGif.altura = Integer.parseInt(screenDescriptor.getAttribute("logicalScreenHeight"));
                }
            }
            
            if (globalColorTable != null && globalColorTable.getLength() > 0)
            {
                IIOMetadataNode colorTable = (IIOMetadataNode) globalColorTable.item(0);
                
                if (colorTable != null)
                {
                    String bgIndex = colorTable.getAttribute("backgroundColorIndex");
                    IIOMetadataNode colorEntry = (IIOMetadataNode) colorTable.getFirstChild();
                    
                    while (colorEntry != null)
                    {
                        if (colorEntry.getAttribute("index").equals(bgIndex))
                        {
                            int red = Integer.parseInt(colorEntry.getAttribute("red"));
                            int green = Integer.parseInt(colorEntry.getAttribute("green"));
                            int blue = Integer.parseInt(colorEntry.getAttribute("blue"));
                            
                            metadadosGif.corFundo = new Color(red, green, blue);
                            
                            break;
                        }
                        colorEntry = (IIOMetadataNode) colorEntry.getNextSibling();
                    }
                }
            }
        }
        
        return metadadosGif;
    }

//    private List<QuadroGif> readGif(InputStream stream) throws IOException
//    {
//        int lastx = 0;
//        int lasty = 0;
//        
//        BufferedImage master = null;
//        boolean hasBackround = false;
//        
//        
//        for (int frameIndex = 0; frameIndex < frameCount; frameIndex++)
//        {
//            BufferedImage image;
//            try
//            {
//                image = leitorGif.read(frameIndex);
//            }
//            catch (IndexOutOfBoundsException io)
//            {
//                continue;
//            }
//            if (width == -1 || height == -1)
//            {
//                width = image.getWidth();
//                height = image.getHeight();
//            }
//            IIOMetadataNode root = (IIOMetadataNode) leitorGif.getImageMetadata(frameIndex).getAsTree("javax_imageio_gif_image_1.0");
//            IIOMetadataNode gce = (IIOMetadataNode) root.getElementsByTagName("GraphicControlExtension").item(0);
//            NodeList children = root.getChildNodes();
//            int delay = Integer.valueOf(gce.getAttribute("delayTime"));
//            String disposal = gce.getAttribute("disposalMethod");
//            if (master == null)
//            {
//                master = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//                master.createGraphics().setColor(backgroundColor);
//                master.createGraphics().fillRect(0, 0, master.getWidth(), master.getHeight());
//                hasBackround = image.getWidth() == width && image.getHeight() == height;
//                master.createGraphics().drawImage(image, 0, 0, null);
//            }
//            else
//            {
//                int x = 0;
//                int y = 0;
//                for (int nodeIndex = 0; nodeIndex < children.getLength(); nodeIndex++)
//                {
//                    Node nodeItem = children.item(nodeIndex);
//                    if (nodeItem.getNodeName().equals("ImageDescriptor"))
//                    {
//                        NamedNodeMap map = nodeItem.getAttributes();
//                        x = Integer.valueOf(map.getNamedItem("imageLeftPosition").getNodeValue());
//                        y = Integer.valueOf(map.getNamedItem("imageTopPosition").getNodeValue());
//                    }
//                }
//                if (disposal.equals("restoreToPrevious"))
//                {
//                    BufferedImage from = null;
//                    for (int i = frameIndex - 1; i >= 0; i--)
//                    {
//                        if (!frames.get(i).disposicao.equals("restoreToPrevious") || frameIndex == 0)
//                        {
//                            from = frames.get(i).imagem;
//                            break;
//                        }
//                    }
//                    {
//                        ColorModel model = from.getColorModel();
//                        boolean alpha = from.isAlphaPremultiplied();
//                        WritableRaster raster = from.copyData(null);
//                        master = new BufferedImage(model, raster, alpha, null);
//                    }
//                }
//                else if (disposal.equals("restoreToBackgroundColor") && backgroundColor != null)
//                {
//                    if (!hasBackround || frameIndex > 1)
//                    {
//                        master.createGraphics().fillRect(lastx, lasty, frames.get(frameIndex - 1).largura, frames.get(frameIndex - 1).altura);
//                    }
//                }
//                master.createGraphics().drawImage(image, x, y, null);
//                lastx = x;
//                lasty = y;
//            }
//            
//            BufferedImage copy;
//            {
//                ColorModel model = master.getColorModel();
//                boolean alpha = master.isAlphaPremultiplied();
//                WritableRaster raster = master.copyData(null);
//                copy = new BufferedImage(model, raster, alpha, null);
//            }
//            frames.add(new QuadroGif(copy, delay, disposal, image.getWidth(), image.getHeight()));
//                
//            master.flush();
//        }
//        leitorGif.dispose();
//        return frames;
//    }
    
    private final class MetadadosGif
    {
        public int largura = -1;
        public int altura = -1;    
        public Color corFundo = null;
        public int numeroFrames = 0;
        public int indiceQuadroAtual = 0;
    }
}
