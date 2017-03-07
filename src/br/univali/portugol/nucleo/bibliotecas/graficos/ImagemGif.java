/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.portugol.nucleo.bibliotecas.graficos;

import br.univali.portugol.nucleo.bibliotecas.base.ErroExecucaoBiblioteca;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
    
    private ImageReader leitorGif;
    private MetadadosGif metadados;
    private BufferedImage notDisposedImage = null;
    private boolean hasANotDisposable = false;
    private boolean firstNotDispose = false;
    private int alturaFutura = 0;
    private int larguraFutura = 0;
    
    private byte[] bytesImagem;

    private ImagemGif()
    {

    }
    
    public ImagemGif(File arquivo) throws ErroExecucaoBiblioteca
    {
        try
        {
            bytesImagem = copiarParaMemoria(arquivo);

             imprimirInformacoesGif(bytesImagem);

            leitorGif = criarLeitorGif(bytesImagem);     
            metadados = lerMetadadosGif();
            avancarQuadro();
        }
        catch (IOException ex)
        {
            throw new ErroExecucaoBiblioteca("Erro ao carregar a imagem GIF");
        }
        
    }    
    
    @Override
    public BufferedImage getImagem() throws ErroExecucaoBiblioteca
    {
        long tempoDesdeUltimoDesenho = System.currentTimeMillis() - metadados.instanteUltimoDesenho;
        int intervaloAtual = metadados.informacoesQuadros[metadados.indiceQuadroAtual].intervalo * 10;
        if (tempoDesdeUltimoDesenho >= intervaloAtual)
        {
            avancarQuadro();
            metadados.instanteUltimoDesenho = System.currentTimeMillis();
        }
        else if (metadados.instanteUltimoDesenho == 0)
        {
           metadados.instanteUltimoDesenho = System.currentTimeMillis();
        }
        
        return metadados.quadroAtual;
    }

    public void avancarQuadro() throws ErroExecucaoBiblioteca
    {
        metadados.indiceQuadroAtual = (metadados.indiceQuadroAtual + 1) % (metadados.numeroQuadros);
        metadados.quadroAtual = lerQuadro(metadados.indiceQuadroAtual);        
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
        return metadados.numeroQuadros;
    }

    public Color getCorFundo()
    {
        return metadados.corFundo;
    }
    
    public int getIndiceQuadroAtual()
    {
        return metadados.indiceQuadroAtual;
    }
    
    public void irParaQuadro(int indice) throws ErroExecucaoBiblioteca
    {
        if (indice > metadados.numeroQuadros - 1)
            throw new ErroExecucaoBiblioteca("O índice do quadro é invalido. Esta imagem GIF possui apenas " + metadados.numeroQuadros + " quadros");
        
        metadados.indiceQuadroAtual = indice;
        metadados.quadroAtual = lerQuadro(indice);
    }
    
    public BufferedImage getQuadroAtual()
    {
        return metadados.quadroAtual;
    }
    
    public int getIntervalo()
    {
        return metadados.informacoesQuadros[metadados.indiceQuadroAtual].intervalo;
    }
    
    public BufferedImage getQuadro(int indice)
    {
        return lerQuadro(indice);
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
        MetadadosGif metadadosGif = new MetadadosGif(leitorGif.getNumImages(true));
        
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
                            boolean isfullBlack = red==0 && green==0 && blue==0;
                            boolean isfullwhite = red==255 && green==255 && blue==255;
                            boolean isGreenChroma = red==0 && green==255 && blue==0;
                            boolean isBlueChroma = red==0 && green==0 && blue==255;
                            boolean isChroma = isBlueChroma|| isGreenChroma|| isfullBlack|| isfullwhite;
//                            if(isChroma){
                                metadadosGif.corFundo = new Color(0,0,0,0);
//                            }else{
//                                metadadosGif.corFundo = new Color(red,green,blue);
//                            }
                            
                            break;
                        }
                        colorEntry = (IIOMetadataNode) colorEntry.getNextSibling();
                    }
                }
            }
        }
        
        metadadosGif.quadroErro = new BufferedImage(metadadosGif.largura, metadadosGif.altura, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = metadadosGif.quadroErro.createGraphics();
        
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, metadadosGif.largura, metadadosGif.altura);
        
        g.dispose();
        
        metadadosGif.quadroErro = Utils.criarImagemCompativel(metadadosGif.quadroErro, false);
        
        return metadadosGif;
    }
    
    private BufferedImage lerQuadro(int frameIndex)
    {        
        boolean hasBackround = false;
        BufferedImage fakeimage = null;
        BufferedImage image = new BufferedImage(metadados.largura, metadados.altura, BufferedImage.TYPE_4BYTE_ABGR);
        
        if(frameIndex == 0)
        {
            hasANotDisposable=false;
            larguraFutura = 0;
            alturaFutura = 0;
        }
        
        while (fakeimage == null && frameIndex < metadados.numeroQuadros)
        {
            try
            {
                fakeimage = leitorGif.read(frameIndex);
            }
            catch (IOException | ArrayIndexOutOfBoundsException ex)
            {
                frameIndex++;
            }                
        }

        if (fakeimage == null)
        {
            fakeimage = metadados.quadroErro;
            
            if (frameIndex > metadados.numeroQuadros - 1)
                frameIndex = metadados.numeroQuadros - 1;
        }
        
        if (metadados.largura == -1 || metadados.altura == -1)
        {
            metadados.largura = fakeimage.getWidth();
            metadados.altura = fakeimage.getHeight();
        }

        InformacoesQuadro quadro = metadados.informacoesQuadros[frameIndex];
        
        quadro.largura = fakeimage.getWidth();
        quadro.altura = fakeimage.getHeight();
            
        try
        {
            IIOMetadataNode root = (IIOMetadataNode) leitorGif.getImageMetadata(frameIndex).getAsTree("javax_imageio_gif_image_1.0");
            IIOMetadataNode gce = (IIOMetadataNode) root.getElementsByTagName("GraphicControlExtension").item(0);
            NodeList children = root.getChildNodes();

            String disposal = gce.getAttribute("disposalMethod");
            int intervalo = Integer.valueOf(gce.getAttribute("delayTime"));                
        
            if(intervalo==0)
            {
                intervalo=10;
            }
        
            quadro.intervalo = intervalo;
            quadro.disposicao = disposal;            

            if (metadados.master != null)
            {
                metadados.master = new BufferedImage(metadados.largura, metadados.altura, BufferedImage.TYPE_INT_ARGB);
                metadados.master.createGraphics();
                Graphics2D g2d = (Graphics2D) metadados.master.getGraphics();                
                g2d.setBackground(metadados.corFundo);
                int x = 0;
                int y = 0;
                g2d.setColor(metadados.corFundo);
                for (int nodeIndex = 0; nodeIndex < children.getLength(); nodeIndex++)
                {
                    Node nodeItem = children.item(nodeIndex);

                    if (nodeItem.getNodeName().equals("ImageDescriptor"))
                    {
                        NamedNodeMap map = nodeItem.getAttributes();

                        x = Integer.valueOf(map.getNamedItem("imageLeftPosition").getNodeValue());
                        y = Integer.valueOf(map.getNamedItem("imageTopPosition").getNodeValue());
                    }
                }
                System.out.println(disposal);
                if (disposal.equals("restoreToPrevious"))
                {
                    
                    BufferedImage from = null;
                    Graphics2D gr2d = (Graphics2D) fakeimage.getGraphics();
                    for (int i = frameIndex; i >=0 ; i--)
                    {    
                        if (!metadados.informacoesQuadros[i].disposicao.equals("restoreToPrevious") || frameIndex == 0)
                        {
                            if(i<0){
                                i=0;
                            }
                            from = lerQuadro(i);
                            break;
                        }
                    }
                    gr2d.drawImage(from, x, y, null);
                }
                else if (disposal.equals("restoreToBackgroundColor") && metadados.corFundo != null)
                {
                    g2d.clearRect(x, y, fakeimage.getWidth(), fakeimage.getHeight());
                }
//                JOptionPane.showMessageDialog(null, new ImageIcon(metadados.master));
                Graphics2D gr2d = (Graphics2D) image.getGraphics();
                gr2d.drawImage(fakeimage, x, y, null);
                if(hasANotDisposable){
//                    JOptionPane.showMessageDialog(null, new ImageIcon(notDisposedImage), "NotDisposable", JOptionPane.INFORMATION_MESSAGE);
                    g2d.drawImage(notDisposedImage, 0, 0, null);
                    g2d.setColor(metadados.corFundo);
                    if(firstNotDispose)
                    {
                        firstNotDispose=false;
                    }
                    else
                    {
                        g2d.clearRect(metadados.lastx, metadados.lasty, larguraFutura, alturaFutura);
                    }
                    larguraFutura = quadro.largura;
                    alturaFutura = quadro.altura;
//                    JOptionPane.showMessageDialog(null, new ImageIcon(metadados.master), "Parte apagada", JOptionPane.INFORMATION_MESSAGE);
                }
//                JOptionPane.showMessageDialog(null, new ImageIcon(fakeimage), "Nova", JOptionPane.INFORMATION_MESSAGE);
                g2d.drawImage(image, 0, 0, null);
//                JOptionPane.showMessageDialog(null, new ImageIcon(metadados.master), "final", JOptionPane.INFORMATION_MESSAGE);                
                metadados.lastx = x;
                metadados.lasty = y;
                if(disposal.equals("doNotDispose") || disposal.equals("none")){
                    firstNotDispose = true;
                    notDisposedImage = metadados.master;
//                    JOptionPane.showMessageDialog(null, new ImageIcon(notDisposedImage), "Salvou como doNotDispose", JOptionPane.INFORMATION_MESSAGE);
                    hasANotDisposable = true;
                }
            }
            else
            {
                metadados.master = new BufferedImage(metadados.largura, metadados.altura, BufferedImage.TYPE_INT_ARGB);
                metadados.master.createGraphics();
                Graphics2D g2d = (Graphics2D) metadados.master.getGraphics();
                g2d.setColor(metadados.corFundo);
                g2d.fillRect(0, 0, metadados.master.getWidth(), metadados.master.getHeight());
                hasBackround = image.getWidth() == metadados.largura && image.getHeight() == metadados.altura;
                System.out.println(disposal);
                Graphics2D gr2d = (Graphics2D) image.getGraphics();
                gr2d.drawImage(fakeimage, 0, 0, null);
                g2d.drawImage(image, 0, 0, null);
//                JOptionPane.showMessageDialog(null, new ImageIcon(metadados.master), "final", JOptionPane.INFORMATION_MESSAGE);                
                if(disposal.equals("doNotDispose") || disposal.equals("none")){
                    firstNotDispose = true;
                    notDisposedImage = metadados.master;
//                    JOptionPane.showMessageDialog(null, new ImageIcon(notDisposedImage), "Salvou como doNotDispose", JOptionPane.INFORMATION_MESSAGE);
                    hasANotDisposable = true;
                }
                
            }
            
            BufferedImage copy;
            {
                ColorModel model = metadados.master.getColorModel();
                boolean alpha = metadados.master.isAlphaPremultiplied();
                WritableRaster raster = metadados.master.copyData(null);
                copy = new BufferedImage(model, raster, alpha, null);
                copy = Utils.criarImagemCompativel(copy, this.metadados.largura, this.metadados.altura, this.metadados.manterQualidade);
            }
//            metadados.master.flush();
            leitorGif.dispose();
            
            return copy;
        }
        catch (IOException ex)
        {
            return image;
        }
    }

    public void setDimensoes(int largura, int altura, boolean manterQualidade)
    {
        this.metadados.largura = largura;
        this.metadados.altura = altura;
        this.metadados.manterQualidade = manterQualidade;
    }
    
    private final class MetadadosGif
    {
        public int largura = -1;
        public int altura = -1;    
        public Color corFundo = null;
        public int numeroQuadros = -1;
        public int indiceQuadroAtual = -1;
        public long instanteUltimoDesenho = 0;
        public boolean manterQualidade = false;
        
        public int lastx = 0;
        public int lasty = 0;
        
        public final InformacoesQuadro[] informacoesQuadros;
        public BufferedImage master = null;
        public BufferedImage quadroAtual = null;
        public BufferedImage quadroErro = null;                 

        public MetadadosGif(int numeroFrames)
        {
            this.numeroQuadros = numeroFrames;
            this.informacoesQuadros = new InformacoesQuadro[numeroFrames];
            
            this.inicializarListaQuadros();
        }
        
        private void inicializarListaQuadros()
        {
            for (int i = 0; i < numeroQuadros; i++)
            {
                informacoesQuadros[i] = new InformacoesQuadro();
            }
        }
    }
    
    public class InformacoesQuadro
    {
        public int intervalo = 10;
        public String disposicao = "";
        public int largura = -1;
        public int altura = -1;
    }
    
    public ImagemGif clonar() throws IOException, ErroExecucaoBiblioteca
    {
        ImagemGif imagemGif = new ImagemGif();
        
        imagemGif.bytesImagem = this.bytesImagem;
        imagemGif.leitorGif = criarLeitorGif(this.bytesImagem);
        //imagemGif.leitorGif = this.leitorGif;
        imagemGif.metadados = imagemGif.lerMetadadosGif();
        imagemGif.avancarQuadro();
        
        return imagemGif;
    }
}
