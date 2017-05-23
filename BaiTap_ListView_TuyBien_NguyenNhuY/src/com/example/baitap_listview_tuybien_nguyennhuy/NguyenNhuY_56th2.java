package com.example.baitap_listview_tuybien_nguyennhuy;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NguyenNhuY_56th2 extends Activity {
    
   Song song = null;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.nguyen_nhu_y_56th2);
       final ArrayList<Song> arr = new ArrayList<Song>();
       try{
           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           DocumentBuilder db= dbf.newDocumentBuilder();
           Document doc = db.parse(getAssets().open("listsong.xml"));
            
           //Lấy về node gốc của mỗi bài hát
           NodeList nodeList = doc.getElementsByTagName("song");
           for(int i=0; i<nodeList.getLength(); i++){
               Node node = nodeList.item(i);
               if(node.getNodeType() == Node.ELEMENT_NODE){
                   song = new Song();
                   Element elm = (Element)node;
                   //Id
                   NodeList idList = elm.getElementsByTagName("id");
                   Element idElement = (Element)idList.item(0);
                   song.setId(idElement.getTextContent().trim());
                    
                   //title
                   NodeList titleList = elm.getElementsByTagName("title");
                   Element titleElement = (Element)titleList.item(0);
                   song.setTitle(titleElement.getTextContent().trim());
                    
                   //singer
                   NodeList singerList = elm.getElementsByTagName("singer");
                   Element singerElement = (Element)singerList.item(0);
                   song.setSinger(singerElement.getTextContent().trim());
                    
                   //duration
                   NodeList durationList = elm.getElementsByTagName("duration");
                   Element durationElement = (Element)durationList.item(0);
                   song.setDuration(durationElement.getTextContent().trim());
                    
                   //icon
                   NodeList iconList = elm.getElementsByTagName("icon");
                   Element iconElement = (Element)iconList.item(0);
                   song.setIcon(iconElement.getTextContent().trim());
                   arr.add(song);
               }
           }
       }catch(Exception e){
            
       }
       ListView lv = (ListView)findViewById(R.id.list);
       MyArrayAdapter mayArr = new MyArrayAdapter(this, R.layout.list_row, arr);
       lv.setAdapter(mayArr);
   }
}