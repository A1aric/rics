	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.Reader;
	import java.lang.reflect.Type;
	import java.util.ArrayList;
	import java.util.List;

	import javax.swing.text.html.HTMLDocument.Iterator;

	import com.google.gson.Gson;
	import com.google.gson.JsonArray;
	import com.google.gson.JsonDeserializer;
	import com.google.gson.JsonElement;
	import com.google.gson.stream.JsonReader;
	import com.google.gson.JsonParser;
	import com.google.gson.reflect.TypeToken;

	public class GetGPA {
		public static void main(String[] args) throws FileNotFoundException {
			System.out.println("Input what course you want to know");
			
			readDataFromJson("CS 173");
		}

		public static void readDataFromJson(String s) throws FileNotFoundException {

			JsonReader file = new JsonReader(new FileReader("src/generic.json"));
			Gson gson = new Gson();
			List<CourseInfo> rs = new ArrayList<CourseInfo>();
			Type type = new TypeToken<ArrayList<CourseInfo>>() {
			}.getType();
			rs = gson.fromJson(file, type);
			for (CourseInfo a : rs) {
				if (a.getName().equals(s)) {
					System.out.println(a.getName() + " " + a.getSum_students());
				}
			}
		}

	}

