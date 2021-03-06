package mesquite.nexml.InterpretNEXML.AnnotationHandlers;

import java.net.URI;

import mesquite.lib.Associable;
import mesquite.lib.Listable;

import mesquite.lib.MesquiteProject;
import mesquite.nexml.InterpretNEXML.NexmlMesquiteManager;
import org.nexml.model.Annotatable;
import org.nexml.model.Annotation;

public abstract class PredicateHandler {
	public abstract Annotatable getSubject();
	public abstract void setSubject(Annotatable subject);
	
	public abstract Object getValue();
	public abstract void setValue(Object value);
	
	public abstract String getPrefix ();

	public abstract String getPredicate();
	public abstract void setPredicate(String predicate);	
	
	public abstract boolean getPropertyIsRel();
	public abstract void setPropertyIsRel(boolean propertyIsRel);
	
	public abstract String getURIString();
	public abstract void setURIString(String uri);

    public PredicateHandler() {
    }

    public PredicateHandler(Annotatable annotatable,Annotation annotation) {
        this();
        initPredicateHandler(annotatable,annotation);
    }

	public PredicateHandler initPredicateHandler(Annotatable annotatable,Annotation annotation) {
		setSubject(annotatable);
		setValue(annotation.getValue());
		String property = annotation.getProperty();
		if ( null == property || "".equals(property) ) {
			property = annotation.getRel();
			setPropertyIsRel(true);
		}		
		setPredicate(property);
        return this;
    }

    String getProperty() {
		return getPrefix () + ":" + getPredicate();
	}
		
	public URI getURI () {
		return URI.create(getURIString());
	}
	public void setURI (URI uri) {
		setURIString(uri.toString());
	}

    public void initializeMesquiteProject(MesquiteProject project) {
    }

    public void read(Associable associable,Listable listable,int index) {

    }
	public void write() {

    }
	
}
