package tabu.TCYB;

import java.util.ArrayList;
import java.util.Random;

import org.coinor.opents.*;

public class GCMove implements Move{

	public Search search;
	public ArrayList<ArrayList<Layout.GROUP>> layoutCode;
	public ArrayList<hash> hashList;
	
	public GCMove(Search search, ArrayList<ArrayList<Layout.GROUP>> layoutCode, ArrayList<hash> hash){
		this.search = search;
		this.layoutCode = layoutCode;
		this.hashList = hash;
	}
   
    public void operateOn(Solution sol)
    {
    	Layout layout = ((GCSolution)sol).layout;
    	ArrayList<ArrayList<ArrayList<Item>>> newRows = layout.decode(this.layoutCode);
    	layout.row = newRows;
    	layout.itemSort();

       //item sort, group sort, row sort, all row sort
       search.LNS(layout, 128); // do at most 4 runs for a single solution
       
      sol.setObjectiveValue(new double[]{layout.objective()});
       
    }   // end operateOn
    
    public ArrayList<hash> hash(){
    	return this.hashList;
    }
    
    
    
} //End class GCMove
