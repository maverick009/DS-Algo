import java.io.*;public class birdDisplay {	public static void copy(File source, File dest) throws IOException	{		try(InputStream in = new BufferedInputStream(new FileInputStream(source)); OutputStream out = new BufferedOutputStream(new FileOutputStream(dest)))					{				int b;			byte [] buffer = new byte[1024];			while((b = in.read(buffer)) > 0)				out.write(buffer,0,b);			out.flush();		}	}	public static void main(String []args)	{		try		{			File base = new File("/home/rakesh/workspace-eclipse");			File source = new File(base, "A.class");			File dest = new File(base, "A.txt");			copy(source,dest);		}		catch(IOException e)		{			System.out.println("hi");		}	}	}
