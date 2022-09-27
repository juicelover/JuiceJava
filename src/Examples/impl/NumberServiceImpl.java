package Examples.impl;

import Examples.util.InputUtils;
import Examples.service.INumberService;

public class NumberServiceImpl implements INumberService {
    @Override
    public int[] stat(int count) {

        int[] result = new int[2];

        int[] data = new int[count];
        for (int i = 0; i < data.length; i++) {
            data[i] = InputUtils.getIntBuf("�������" + (i + 1) + "�����֣�");
        }
        result[0] = data[0];
        result[1] = data[1];
        for (int datum : data) {
            if (datum > result[0]) {
                result[0] = datum;
            }
            if (datum < result[1]) {
                result[1] = datum;
            }
        }
        return result;
    }

    @Override
    public int[] stat() {
        int[] stat = {0, 0};
        String str = InputUtils.getString("������������Ϣ��");
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            if (Integer.parseInt(split[i]) % 2 == 0) {
                stat[0]++;
            } else {
                stat[1]++;
            }
        }
        return stat;
    }
}
