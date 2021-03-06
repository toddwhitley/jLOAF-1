package org.jLOAF.action;

import java.util.ArrayList;
import java.util.List;

import org.jLOAF.inputs.Feature;

public class AtomicAction extends Action {

	private static final long serialVersionUID = 1L;

	protected Feature feat;
	
	List<Feature> features;

	public AtomicAction(String name) {
		super(name);
		features = new ArrayList<Feature>();
	}

	public int getNumFeatures(){
		return this.features.size();
	}
	
	public void addFeature(Feature f){
		this.features.add(f);
	}
	
	public Feature getFeature(int idx){
		if(idx > features.size() -1){
			return null;
		}else{
			return features.get(idx);
		}
	}
	
	public List<Feature> getFeatures(){
		return this.features;
	}
}
