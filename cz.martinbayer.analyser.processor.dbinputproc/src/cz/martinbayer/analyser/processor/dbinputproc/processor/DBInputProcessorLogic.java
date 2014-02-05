package cz.martinbayer.analyser.processor.dbinputproc.processor;

import cz.martinbayer.analyser.impl.ConcreteData;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class DBInputProcessorLogic implements IProcessorLogic<ConcreteData>{

	@Override
	public LogProcessor<ConcreteData> getProcessor() {
		return new DBInputProcessor();
	}

	
}
