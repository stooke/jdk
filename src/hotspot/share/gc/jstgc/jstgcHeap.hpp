#if !defined(JSTGC_HEAP)

#include "gc/epsilon/epsilonHeap.hpp"
#include "gc/shared/markBitMap.hpp"

class JstgcHeap : public EpsilonHeap {

  MemRegion  _bitmap_region;
  MarkBitMap _bitmap;

public:

JstgcHeap() : EpsilonHeap() {

}

};


#endif
