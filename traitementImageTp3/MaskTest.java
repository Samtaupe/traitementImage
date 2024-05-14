package traitementImageTp3;

import java.io.IOException;

import traitementImageTp1.GreyImage;
import traitementImageTp1.GreyImageTest;
import traitementImageTp2.Histogram;

public class MaskTest {
	public static void main(String[] args) {
		short[] dataM1 = {	1, 1, 1,
							1, 1, 1,
							1, 1, 1};
		short[] dataM2 = {	1, 1, 1, 1, 1,
							1, 1, 1, 1, 1,
							1, 1, 1, 1, 1,
							1, 1, 1, 1, 1,
							1, 1, 1, 1, 1};
		short[] dataM3 = {	-1, -2, -1, 
							0, 0, 0, 
								1, 2, 1};
		short[] dataM4 = {	0, -1, -2, -1, 0,
							0, -1, -2, -1, 0,
							0, 0, 0, 0, 0,
							0, 1, 2, 1, 0,
							0, 1, 2, 1, 0};
		

		try {
			GreyImage greyImage = GreyImage.loadPGM("C:/Users/thoma/git/JavaAnnee2Sem1/traitementImageTp1/imgs/barbara.pgm");
			GreyImage greyImage2= GreyImage.loadPGM("C:/Users/thoma/git/JavaAnnee2Sem1/traitementImageTp1/imgs/barbara.pgm");
			
			GreyImage imgNoise = greyImage.addGaussianNoise(0,30);
			imgNoise.savePGM("gaussianNoise.pgm");	
			
			Mask m1 = new Mask(dataM1, 3);
			GreyImage imgF1 = greyImage.convolve(m1);
			imgF1.truncate((short)0, (short)255);
			imgF1.savePGM("imgF1.pgm");
			System.out.println(greyImage2.computeNMSE(imgF1));

			Mask m2 = new Mask(dataM2, 5);
			GreyImage imgF2 = greyImage.convolve(m2);
			imgF2.truncate((short)0, (short)255);
			imgF2.savePGM("imgF2.pgm");
			System.out.println(greyImage2.computeNMSE(imgF2));
			
			GreyImage imgF3 = greyImage.medianFilter(3);
			imgF3.truncate((short)0, (short)255);
			imgF3.savePGM("imgF3.pgm");
			System.out.println(greyImage2.computeNMSE(imgF3));
			
			GreyImage imgF4 = greyImage.medianFilter(5);
			imgF4.truncate((short)0, (short)255);
			imgF4.savePGM("imgF4.pgm");
			System.out.println(greyImage2.computeNMSE(imgF4));
			
		}catch(Exception e){
			System.err.println("Exception"+e.getMessage());
		}
	}
}

