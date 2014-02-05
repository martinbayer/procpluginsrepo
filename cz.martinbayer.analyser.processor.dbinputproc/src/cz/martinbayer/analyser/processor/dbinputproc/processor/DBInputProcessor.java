package cz.martinbayer.analyser.processor.dbinputproc.processor;

import java.util.ArrayList;
import java.util.Random;

import cz.martinbayer.analyser.impl.ConcreteData;
import cz.martinbayer.analyser.processors.model.ELogLevel;
import cz.martinbayer.analyser.processors.model.XMLogData;
import cz.martinbayer.analyser.processors.types.InputProcessor;

public class DBInputProcessor extends InputProcessor<ConcreteData> {

	private static final String NAME = "Database input processor";
	private ArrayList<DataWrapper> roughData = new ArrayList<>();

	private RandomString rndString = new RandomString(10);

	@Override
	protected void process() {
		if (nextProcessor != null) {
			nextProcessor.setLogData(logData);
			nextProcessor.run();
		}
	}

	@Override
	protected void read() {
		processReading();
		initXMLogData();
	}

	private void initXMLogData() {
		logData = new XMLogData<>();
		for (DataWrapper wrapper : roughData) {
			logData.addLogRecord(new ConcreteData(wrapper.getLevel(), wrapper
					.getText(), false));
		}
	}

	private void processReading() {
		DataWrapper wrapper;
		for (int i = 0; i < 50; i++) {
			wrapper = new DataWrapper(getRandomText(), getRandomLevel());
			roughData.add(wrapper);
		}
	}

	private String getRandomText() {
		return rndString.nextString();
	}

	private ELogLevel getRandomLevel() {
		int levelIdx = (int) (Math.random() * 4);
		switch (levelIdx) {
		case 0:
			return ELogLevel.DEBUG;
		case 1:
			return ELogLevel.ERROR;
		case 2:
			return ELogLevel.INFO;
		case 3:
			return ELogLevel.TRACE;
		case 4:
			return ELogLevel.WARN;

		default:
			return ELogLevel.INFO;
		}
	}

	@Override
	public String getName() {
		return NAME;
	}

}

class DataWrapper {
	private String text;
	private ELogLevel level;

	public DataWrapper(String text, ELogLevel level) {
		this.text = text;
		this.level = level;
	}

	public String getText() {
		return text;
	}

	public ELogLevel getLevel() {
		return level;
	}

}

class RandomString {
	private static final char[] symbols = new char[36];

	static {
		for (int idx = 0; idx < 10; ++idx)
			symbols[idx] = (char) ('0' + idx);
		for (int idx = 10; idx < 36; ++idx)
			symbols[idx] = (char) ('a' + idx - 10);
	}

	private final Random random = new Random();

	private final char[] buf;

	public RandomString(int length) {
		if (length < 1)
			throw new IllegalArgumentException("length < 1: " + length);
		buf = new char[length];
	}

	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}
}