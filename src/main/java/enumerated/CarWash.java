package enumerated;

import utils.PrintUtil;

/**
 * Created by yuez on 14-1-23
 */
public class CarWash {
    public enum Cycle {
        UNDERBODY {
            @Override
            void action() {
                PrintUtil.print("Spraying the underbody");
            }
        },
        WHEELWASH {
            @Override
            void action() {
                PrintUtil.print("Washing the wheels");
            }
        };

        abstract void action();
    }
}
