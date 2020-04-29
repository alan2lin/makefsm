
package com.github.alan2lin.runtime;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ProcessorFSMImpl extends ProcessorFSM {


      @Override
      public boolean checkBeforeStart__init(EVENT event){
         return super.checkBeforeStart__init(event);
      }

      @Override
      public boolean onStart__init(EVENT event){
         return super.onStart__init(event);
      }

      @Override
      public boolean recoverStart__init(EVENT event){
         return super.recoverStart__init(event);
      }

      @Override
       public boolean checkAfterStart__init(EVENT event){
         return super.checkAfterStart__init(event);
      }

      @Override
       public void enterStart__init(EVENT event,States target){
           super.enterStart__init(event,target);
       }

      @Override
      public boolean checkBeforeReady__start(EVENT event){
         return super.checkBeforeReady__start(event);
      }

      @Override
      public boolean onReady__start(EVENT event){
         return super.onReady__start(event);
      }

      @Override
      public boolean recoverReady__start(EVENT event){
         return super.recoverReady__start(event);
      }

      @Override
       public boolean checkAfterReady__start(EVENT event){
         return super.checkAfterReady__start(event);
      }

      @Override
       public void enterReady__start(EVENT event,States target){
           super.enterReady__start(event,target);
       }

      @Override
      public boolean checkBeforeRunning__pause(EVENT event){
         return super.checkBeforeRunning__pause(event);
      }

      @Override
      public boolean onRunning__pause(EVENT event){
         return super.onRunning__pause(event);
      }

      @Override
      public boolean recoverRunning__pause(EVENT event){
         return super.recoverRunning__pause(event);
      }

      @Override
       public boolean checkAfterRunning__pause(EVENT event){
         return super.checkAfterRunning__pause(event);
      }

      @Override
       public void enterRunning__pause(EVENT event,States target){
           super.enterRunning__pause(event,target);
       }

      @Override
      public boolean checkBeforePause_locked__pauseWaiting(EVENT event){
         return super.checkBeforePause_locked__pauseWaiting(event);
      }

      @Override
      public boolean onPause_locked__pauseWaiting(EVENT event){
         return super.onPause_locked__pauseWaiting(event);
      }

      @Override
      public boolean recoverPause_locked__pauseWaiting(EVENT event){
         return super.recoverPause_locked__pauseWaiting(event);
      }

      @Override
       public boolean checkAfterPause_locked__pauseWaiting(EVENT event){
         return super.checkAfterPause_locked__pauseWaiting(event);
      }

      @Override
       public void enterPause_locked__pauseWaiting(EVENT event,States target){
           super.enterPause_locked__pauseWaiting(event,target);
       }

      @Override
      public boolean checkBeforePause__resume(EVENT event){
         return super.checkBeforePause__resume(event);
      }

      @Override
      public boolean onPause__resume(EVENT event){
         return super.onPause__resume(event);
      }

      @Override
      public boolean recoverPause__resume(EVENT event){
         return super.recoverPause__resume(event);
      }

      @Override
       public boolean checkAfterPause__resume(EVENT event){
         return super.checkAfterPause__resume(event);
      }

      @Override
       public void enterPause__resume(EVENT event,States target){
           super.enterPause__resume(event,target);
       }

      @Override
      public boolean checkBeforePause_unlocked__resumeWaiting(EVENT event){
         return super.checkBeforePause_unlocked__resumeWaiting(event);
      }

      @Override
      public boolean onPause_unlocked__resumeWaiting(EVENT event){
         return super.onPause_unlocked__resumeWaiting(event);
      }

      @Override
      public boolean recoverPause_unlocked__resumeWaiting(EVENT event){
         return super.recoverPause_unlocked__resumeWaiting(event);
      }

      @Override
       public boolean checkAfterPause_unlocked__resumeWaiting(EVENT event){
         return super.checkAfterPause_unlocked__resumeWaiting(event);
      }

      @Override
       public void enterPause_unlocked__resumeWaiting(EVENT event,States target){
           super.enterPause_unlocked__resumeWaiting(event,target);
       }

      @Override
      public boolean checkBeforeRunning__stop(EVENT event){
         return super.checkBeforeRunning__stop(event);
      }

      @Override
      public boolean onRunning__stop(EVENT event){
         return super.onRunning__stop(event);
      }

      @Override
      public boolean recoverRunning__stop(EVENT event){
         return super.recoverRunning__stop(event);
      }

      @Override
       public boolean checkAfterRunning__stop(EVENT event){
         return super.checkAfterRunning__stop(event);
      }

      @Override
       public void enterRunning__stop(EVENT event,States target){
           super.enterRunning__stop(event,target);
       }

      @Override
      public boolean checkBeforeStop_locked__stopWating(EVENT event){
         return super.checkBeforeStop_locked__stopWating(event);
      }

      @Override
      public boolean onStop_locked__stopWating(EVENT event){
         return super.onStop_locked__stopWating(event);
      }

      @Override
      public boolean recoverStop_locked__stopWating(EVENT event){
         return super.recoverStop_locked__stopWating(event);
      }

      @Override
       public boolean checkAfterStop_locked__stopWating(EVENT event){
         return super.checkAfterStop_locked__stopWating(event);
      }

      @Override
       public void enterStop_locked__stopWating(EVENT event,States target){
           super.enterStop_locked__stopWating(event,target);
       }


  }